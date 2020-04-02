package com.project.buyit.user.domain.command;

import com.project.buyit.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserCommandService commandService;

    @PostMapping(path = "/registration", consumes = "application/json")
    public ResponseEntity registerUser(@RequestBody @Valid UserRegistrationCommand userRegistrationCommand) {
        return ValidationResolver.resolve(commandService.createUser(userRegistrationCommand));
    }
}
