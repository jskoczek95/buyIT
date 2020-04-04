package com.project.buyit.user.infrastructure.entrypoint;

import com.project.buyit.user.infrastructure.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserQueryController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsQuery> getUserById(@PathVariable UUID id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .getOrElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<UserDetailsQuery> getAllUsers(@PageableDefault(size = 10, sort = {"lastName"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.getAllUsers(pageable);
    }
}
