package com.web_project.flower.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private Long idUser;

    private String username;
    @Size(min = 3, message = "Пароль не менее 3 символов")
    private String password;
    private boolean active;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles;

    public UserModel() {

    }

    public UserModel(Long idUser, String username, String password, boolean active, Set<RoleEnum> roles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public @Size(min = 3, message = "Пароль не менее 3 символов") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 3, message = "Пароль не менее 3 символов") String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }
}
