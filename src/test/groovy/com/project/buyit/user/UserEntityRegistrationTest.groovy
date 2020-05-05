package com.project.buyit.user


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static com.project.buyit.UserTestUtils.*
import static com.project.buyit.domain.users.CreateUserCommand.Input
import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserEntityRegistrationTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    private static final String URL = "/users/registration"

    def "should successfully register user"() {
        expect:
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(createDummyRegistrationUser())))
                .andExpect(status().isOk()).andReturn()
    }

    def createDummyRegistrationUser() {
        return new Input(FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, PASSWORD)
    }
}
