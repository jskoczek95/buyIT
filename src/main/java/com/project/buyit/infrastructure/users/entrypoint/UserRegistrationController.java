package com.project.buyit.infrastructure.users.entrypoint;

import com.project.buyit.domain.users.CreateUserCommand;
import com.project.buyit.infrastructure.validation.ValidationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.project.buyit.domain.users.CreateUserCommand.Input;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final CreateUserCommand command;

    @PostMapping(path = "/registration", consumes = "application/json")
    public ResponseEntity registerUser(@RequestBody Input input) {
        return ValidationResolver.resolveEither(command.execute(input));
    }
}
