package com.MyOrg.Linkly.repository;

import com.MyOrg.Linkly.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl,Long> {
    Optional<ShortUrl> findByShortCode(String shortCode);
}
