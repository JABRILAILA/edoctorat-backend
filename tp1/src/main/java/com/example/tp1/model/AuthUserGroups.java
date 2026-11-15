package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "auth_user_groups")
public class AuthUserGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser user;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroup group;

    public AuthUserGroups() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public AuthUser getUser() { return user; }
    public void setUser(AuthUser user) { this.user = user; }
    public AuthGroup getGroup() { return group; }
    public void setGroup(AuthGroup group) { this.group = group; }
}