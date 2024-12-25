package com.spinel.hexagonal.infrastructure.adapters;

import com.spinel.hexagonal.domain.models.AdditionalTaskInfo;
import com.spinel.hexagonal.domain.ports.out.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceholderTodo> response = restTemplate.getForEntity(
                apiUrl,
                JsonPlaceholderTodo.class
        );
        JsonPlaceholderTodo todo = response.getBody();

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> userResponse = restTemplate.getForEntity(
                apiUrl,
                JsonPlaceholderUser.class
        );
        JsonPlaceholderUser user = userResponse.getBody();

        return new AdditionalTaskInfo(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    private static class JsonPlaceholderTodo {
        // https://jsonplaceholder.typicode.com/todos/
        private Long id;
        private Long userId;

        public Long getId() {
            return id;
        }

        public Long getUserId() {
            return userId;
        }
    }

    private static class JsonPlaceholderUser {
        // https://jsonplaceholder.typicode.com/users/
        private Long   id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }
}
