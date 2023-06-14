package com.duroop.dodom.domain.tag.repository;

import com.duroop.dodom.domain.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Long> {
}
