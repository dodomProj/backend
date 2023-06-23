package com.duroop.dodom.domain.appointmentTime.repository;

import com.duroop.dodom.domain.appointmentTime.entity.AppointmentTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentTimeRepository extends JpaRepository<AppointmentTime, Long> {
}
