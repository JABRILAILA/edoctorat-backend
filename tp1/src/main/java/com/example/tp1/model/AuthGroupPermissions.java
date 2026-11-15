package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "auth_group_permissions")
public class AuthGroupPermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroup group;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private AuthPermission permission;

    public AuthGroupPermissions() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public AuthGroup getGroup() { return group; }
    public void setGroup(AuthGroup group) { this.group = group; }
    public AuthPermission getPermission() { return permission; }
    public void setPermission(AuthPermission permission) { this.permission = permission; }
}