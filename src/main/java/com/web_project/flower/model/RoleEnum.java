package com.web_project.flower.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER, COURIER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
