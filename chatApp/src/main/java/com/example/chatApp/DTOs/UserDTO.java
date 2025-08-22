package com.example.chatApp.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @JsonProperty("user_name")
    private String username;

    private String password;
}
