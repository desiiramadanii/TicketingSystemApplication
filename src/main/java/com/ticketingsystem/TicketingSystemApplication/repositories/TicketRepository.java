package com.ticketingsystem.TicketingSystemApplication.repositories;

import com.ticketingsystem.TicketingSystemApplication.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, String> {

    @Query(value = """
            SELECT * 
            FROM Ticket
            WHERE DueDate LIKE CONCAT('%',:dueDate,'%')
            """, nativeQuery = true)
    List<Ticket> findAllTicketByDate(@Param("dueDate") String dueDate);

    @Query(value = """
            SELECT * 
            FROM Ticket
            WHERE [Status] = :status
            """, nativeQuery = true)
    List<Ticket> findAllTicketByStatus(@Param("status") String status);

    @Query(value = """
            SELECT * 
            FROM Ticket
            WHERE Urgency = :urgency
            """, nativeQuery = true)
    List<Ticket> findAllTicketOrderByUrgency(@Param("urgency") String urgency);
}