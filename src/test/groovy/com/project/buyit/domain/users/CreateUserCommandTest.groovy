package com.project.buyit.domain.users

import com.project.buyit.domain.errors.ResponseError
import io.vavr.control.Option
import spock.lang.Specification

import static com.project.buyit.UserTestUtils.*
import static com.project.buyit.domain.users.UserDataProvider.*

class CreateUserCommandTest extends Specification {


    def userDataProvider = Mock(UserDataProvider)

    protected CreateUserCommand createUserCommand = new CreateUserCommand(userDataProvider)

    def "should create user"() {
        given:
        def someInput = createDummyInput()

        when:
        userDataProvider.findByEmail(EMAIL) >> Option.none()
        userDataProvider.save(_ as SaveUserParams) >> someResult()
        def result = createUserCommand.execute(someInput)

        then:
        result.get().address == ADDRESS
        result.get().firstName == FIRST_NAME
        result.get().lastName == LAST_NAME
        result.get().email == EMAIL
    }

    def "should return responseError since user already exists"() {
        given:
        def someInput = createDummyInput()

        when:
        userDataProvider.findByEmail(EMAIL) >> Option.some(GetUserResult.class)
        def result = createUserCommand.execute(someInput)

        then:
        result.isLeft()
        result.left.httpCode == 400
        result.left.message == 'User with given email already exists'
        result.left == ResponseError.NOT_UNIQUE_EMAIL
    }

    private static CreateUserCommand.Input createDummyInput() {
        return new CreateUserCommand.Input(FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, PASSWORD)
    }

    protected static SaveUserResult someResult() {
        return new SaveUserResult(
                null, EMAIL, ADDRESS, FIRST_NAME, LAST_NAME, PASSWORD, ENABLED
        )
    }
}
