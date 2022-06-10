package com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory;

import com.ticketingsystem.TicketingSystemApplication.dataEnum.StatusHistory;
import com.ticketingsystem.TicketingSystemApplication.models.Ticket;
import com.ticketingsystem.TicketingSystemApplication.models.TicketHistory;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class TicketHistoryDto implements Serializable {

    private final String description;
    private final String completedDate;
    private final String approvedById;

    private String statusByCompletedDate(Ticket date){
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        StatusHistory status = null;

        LocalDate dueDate = date.getDueDate();
        LocalDate completeDate = LocalDate.parse(completedDate, formatTgl);

        if (completeDate.isAfter(dueDate)){
            status = StatusHistory.OVERDUE;
        } else {
            status = StatusHistory.ON_TIME;
        }
        return status.name();
    }

    public TicketHistory convert(Ticket ticket){
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        return new TicketHistory(
                ticket,
                description,
                LocalDate.parse(completedDate, formatTgl),
                statusByCompletedDate(ticket),
                approvedById
        );
    }
}
