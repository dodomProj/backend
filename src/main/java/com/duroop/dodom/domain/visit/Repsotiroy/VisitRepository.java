package com.duroop.dodom.domain.visit.Repsotiroy;

import com.duroop.dodom.domain.visit.entity.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visits, Long> {
}
