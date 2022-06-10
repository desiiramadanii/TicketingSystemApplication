package com.ticketingsystem.TicketingSystemApplication.dtos.ticket;

import com.ticketingsystem.TicketingSystemApplication.models.Ticket;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class TicketUpdateDto implements Serializable {
    private final String title;
    private final String details;
    private final String dueDate;
    private final String urgency;

    public Ticket convert(){
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));
        return new Ticket(
                title,
                details,
                LocalDate.parse(dueDate, formatTgl),
                urgency);
    }
}
