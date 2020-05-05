package com.project.buyit.infrastructure.users.entrypoint;

import com.project.buyit.domain.users.GetUserQuery;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.project.buyit.domain.users.GetUserQuery.Input;
import static com.project.buyit.domain.users.GetUserQuery.Output;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserQueryController {

    private final GetUserQuery query;

    @GetMapping("/{id}")
    public ResponseEntity<Output> getUserById(@PathVariable UUID id) {
        return query.findById(Input.byId(id))
                .map(ResponseEntity::ok)
                .getOrElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Output> getAllUsers() {
        return query.getAllUsers();
    }
}
