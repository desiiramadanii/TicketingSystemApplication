package com.ticketingsystem.TicketingSystemApplication.dtos.ticket;

import com.ticketingsystem.TicketingSystemApplication.models.Ticket;
import lombok.Data;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class TicketGridDto implements Serializable {
    private final String id;
    private final String title;
    private final String details;
    private final String requestDate;
    private final String dueDate;
    private final String urgency;
    private final String status;
    private final String createdById;
    private final String appointedToId;

    public static List<TicketGridDto> toList(List<Ticket> tickets){
        List<TicketGridDto> result = new ArrayList<>();

        for (Ticket ticket: tickets) {
            result.add(set(ticket));
        }
        return result;
    }

    public static TicketGridDto oneTicket(Ticket ticket){
        return set(ticket);
    }

    public static TicketGridDto set(Ticket ticket){
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        return new TicketGridDto(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDetails(),
                ticket.getRequestDate().format(formatTgl),
                ticket.getDueDate().format(formatTgl),
                ticket.getUrgency(),
                ticket.getStatus(),
                ticket.getCreatedBy().fetchFullName(),
                ticket.getAppointedTo().fetchFullName()
        );
    }
}
