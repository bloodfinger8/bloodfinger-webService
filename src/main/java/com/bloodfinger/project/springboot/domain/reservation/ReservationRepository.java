package com.bloodfinger.project.springboot.domain.reservation;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {

}
