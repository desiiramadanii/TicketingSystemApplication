package com.ticketingsystem.TicketingSystemApplication.dtos.ticket;

import com.ticketingsystem.TicketingSystemApplication.dataEnum.StatusTicket;
import com.ticketingsystem.TicketingSystemApplication.models.Ticket;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class TicketInsertDto implements Serializable {
    private String id;
    private String title;
    private String details;
    private LocalDate requestDate = LocalDate.now();
    private LocalDate dueDate;
    private String urgency;
    private String createdById;
    private String appointedToId;
    private StatusTicket statusTicket = StatusTicket.IN_PROGRESS;

    public Ticket convert(){
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));
        return new Ticket(
                id,
                title,
                details,
                requestDate,
                LocalDate.parse(dueDate.format(formatTanggal), formatTanggal),
                urgency,
                createdById,
                appointedToId,
                statusTicket
        );
    }


    public TicketInsertDto(String id, String title, String details, String dueDate, String urgency, String createdById, String appointedToId) {
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        this.id = id;
        this.title = title;
        this.details = details;
        this.dueDate = LocalDate.parse(dueDate, formatTgl);
        this.urgency = urgency;
        this.createdById = createdById;
        this.appointedToId = appointedToId;
    }
}
