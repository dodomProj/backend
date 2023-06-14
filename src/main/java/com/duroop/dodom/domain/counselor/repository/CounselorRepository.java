package com.duroop.dodom.domain.counselor.repository;


import com.duroop.dodom.domain.counselor.entity.Counselor;
import com.duroop.dodom.domain.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CounselorRepository extends JpaRepository<Counselor, Long> {
    Optional<List<Counselor>> findAllByTag(Tag tag);
}
