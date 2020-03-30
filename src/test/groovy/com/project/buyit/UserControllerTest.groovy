package com.project.buyit

import com.project.buyit.user.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    private static final String URL = "/users/registration"
    private static final String FIRST_NAME = "John"
    private static final String LAST_NAME = "Doe"
    private static final String EMAIL = "dummyemail@email.com"
    private static final String PASSWORD = "secretpassword"
    private static final String ADDRESS = "dummyaddress12"

    def "should successfully register user and return status 201"() {
        expect:
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(createDummyRegistrationUser())))
                .andExpect(status().isCreated()).andReturn()
    }

    def createDummyRegistrationUser() {
        return UserDto.builder().firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .address(ADDRESS)
                .password(PASSWORD).build()
    }
}
