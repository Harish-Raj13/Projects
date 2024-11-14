package com.harishraj.springsecuritydemo.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Lob  // Large Object for binary data
    private byte[] content;

    public Video() {}

    public Video(String name, String description, byte[] content) {
        this.name = name;
        this.description = description;
        this.content = content;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
