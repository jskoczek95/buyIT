package com.project.buyit.user.domain.query;

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

    private final UserQueryService queryService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsQuery> getUserById(@PathVariable UUID id) {
        return queryService.findById(id)
                .map(ResponseEntity::ok)
                .getOrElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<UserDetailsQuery> getAllUsers(@PageableDefault(size = 10, sort = {"lastName"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return queryService.getAllUsers(pageable);
    }
}
