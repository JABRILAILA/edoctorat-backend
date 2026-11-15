package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "auth_permission")
public class AuthPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "content_type_id", nullable = false)
    private Integer contentTypeId;

    @Column(nullable = false, length = 100)
    private String codename;

    public AuthPermission() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getContentTypeId() { return contentTypeId; }
    public void setContentTypeId(Integer contentTypeId) { this.contentTypeId = contentTypeId; }
    public String getCodename() { return codename; }
    public void setCodename(String codename) { this.codename = codename; }
}