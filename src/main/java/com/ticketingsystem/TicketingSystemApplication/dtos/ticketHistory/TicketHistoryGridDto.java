package com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory;

import com.ticketingsystem.TicketingSystemApplication.models.TicketHistory;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class TicketHistoryGridDto implements Serializable {
    private final String id;
    private final String description;
    private final LocalDate completedDate;
    private final String status;
    private final String approvedById;

    public static List<TicketHistoryGridDto> toList(List<TicketHistory> ticketHistories){
        List<TicketHistoryGridDto> result = new ArrayList<>();

        for (TicketHistory ticketHistory: ticketHistories) {
            result.add(set(ticketHistory));
        }
        return result;
    }

    public static TicketHistoryGridDto set(TicketHistory ticketHistory){
        return new TicketHistoryGridDto(
                ticketHistory.getId(),
                ticketHistory.getDescription(),
                ticketHistory.getCompletedDate(),
                ticketHistory.getStatus(),
                ticketHistory.getApprovedBy().getId()
        );
    }


}
