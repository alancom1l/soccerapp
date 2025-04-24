package com.soccerapp.dto;

import com.soccerapp.model.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
){
}
