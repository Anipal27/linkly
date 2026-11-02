package com.MyOrg.Linkly.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "short_urls")
@Getter
@Setter
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    private String shortCode;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();
}
