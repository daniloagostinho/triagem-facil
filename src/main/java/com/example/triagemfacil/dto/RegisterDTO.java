package com.example.triagemfacil.dto;

import com.example.triagemfacil.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
