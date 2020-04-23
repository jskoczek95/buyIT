package com.project.buyit.bidding.domain

import com.project.buyit.bidding.domain.offer.Offer
import com.project.buyit.bidding.domain.offer.OfferingDataProvider
import com.project.buyit.offer.infrastructure.entrypoint.OfferCreationDto
import com.project.buyit.validation.ResponseError
import io.vavr.control.Option
import spock.lang.Specification
import spock.lang.Unroll

class BiddingFacadeTest extends Specification {

    private static final String TITLE = "Title"
    private static final String DESCRIPTION = "Some description"
    private static final BigDecimal PRICE_WITH_GOOD_FORMAT = BigDecimal.valueOf(19.25)
    private static final BigDecimal PRICE_WITH_WRONG_FORMAT = BigDecimal.valueOf(10.23412)
    private static final BigDecimal NULL_PRICE = null
    private static final String EMPTY_TITLE = ""
    private static final String EMPTY_DESCRIPTION = ""
    private static final String NULL_TITLE = null
    private static final String NULL_DESCRIPTION = null
    private static final UUID OFFER_ID = UUID.randomUUID()

    def offerProvider = Mock(OfferingDataProvider)
    def offerFacade = new BiddingFacade(offerProvider)

    def "should successfully create new offer"() {
        given:
        def offerCreationDto = dummyDto(TITLE, DESCRIPTION, PRICE_WITH_GOOD_FORMAT)

        when:
        offerProvider.save(_ as Offer) >> toDomain(offerCreationDto)
        def result = offerFacade.createOffer(offerCreationDto).get()

        then:
        result.description == offerCreationDto.description
        result.title == offerCreationDto.title
        result.startingPrice == offerCreationDto.price
    }

    @Unroll
    def "should return #error because of invalid input"() {
        given:
        def offerCreationDto = dummyDto(title, description, price)

        when:
        def result = offerFacade.createOffer(offerCreationDto).getLeft()

        then:
        result == error

        where:
        title       | description       | price                   | error
        TITLE       | DESCRIPTION       | PRICE_WITH_WRONG_FORMAT | ResponseError.WRONG_PRICE_FORMAT
        EMPTY_TITLE | DESCRIPTION       | PRICE_WITH_GOOD_FORMAT  | ResponseError.EMPTY_TITLE_OR_DESCRIPTION
        NULL_TITLE  | DESCRIPTION       | PRICE_WITH_GOOD_FORMAT  | ResponseError.EMPTY_TITLE_OR_DESCRIPTION
        TITLE       | NULL_DESCRIPTION  | PRICE_WITH_GOOD_FORMAT  | ResponseError.EMPTY_TITLE_OR_DESCRIPTION
        TITLE       | EMPTY_DESCRIPTION | PRICE_WITH_GOOD_FORMAT  | ResponseError.EMPTY_TITLE_OR_DESCRIPTION
        TITLE       | EMPTY_DESCRIPTION | NULL_PRICE              | ResponseError.WRONG_PRICE_FORMAT
    }

    def "should find offer by it's id"() {
        given:
        def offerDomain = new Offer(OFFER_ID, TITLE, DESCRIPTION, PRICE_WITH_GOOD_FORMAT)

        when:
        offerProvider.findById(OFFER_ID) >> offerDomain
        def result = offerFacade.findById(OFFER_ID).get()

        then:
        result.id == offerDomain.id
        result.title == offerDomain.title
        result.description == offerDomain.description
        result.startingPrice == offerDomain.startingPrice
        result == offerDomain
    }

    def "should return error because of invalid id"() {
        given:
        def offerDomain = new Offer(OFFER_ID, TITLE, DESCRIPTION, PRICE_WITH_GOOD_FORMAT)

        when:
        offerProvider.findById(OFFER_ID) >> offerDomain
        def result = offerFacade.findById(UUID.randomUUID())

        then:
        result == Option.none()
    }

    private static OfferCreationDto dummyDto(String title, String description, BigDecimal price) {
        return new OfferCreationDto(title, description, price)
    }

    private static Offer toDomain(OfferCreationDto offer) {
        return new Offer(offer.getTitle(), offer.getDescription(), offer.getPrice());
    }

}
