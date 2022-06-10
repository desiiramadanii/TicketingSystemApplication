package com.ticketingsystem.TicketingSystemApplication.repositories;

import com.ticketingsystem.TicketingSystemApplication.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}