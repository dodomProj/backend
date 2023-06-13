package com.duroop.dodom.tag.repository;

import com.duroop.dodom.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Long> {
}
