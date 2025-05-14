package com.doka.organizer.entity;

public record RegisterDTO(String login, String password, UserRole role) {
}
