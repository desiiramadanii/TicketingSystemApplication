package com.ticketingsystem.TicketingSystemApplication.repositories;

import com.ticketingsystem.TicketingSystemApplication.models.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketHistoryRepository extends JpaRepository<TicketHistory, String> {

}