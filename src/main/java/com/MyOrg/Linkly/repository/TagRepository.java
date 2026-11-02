package com.MyOrg.Linkly.repository;


import com.MyOrg.Linkly.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
