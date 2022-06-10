package com.ticketingsystem.TicketingSystemApplication.services;

import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketGridDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketInsertDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketUpdateDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory.TicketHistoryDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory.TicketHistoryGridDto;

import java.util.List;

public interface TicketService {

    public List<TicketGridDto> findAllTicket();
    public TicketGridDto findTicketById(String id);
    public TicketGridDto insertTicket(TicketInsertDto newTicket);
    public TicketGridDto updateTicketById(String id, TicketUpdateDto updateTicket);
    public TicketGridDto deleteTicketById(String id);
    public TicketGridDto updateTicketStatusCanceled(String id);
    public List<TicketHistoryGridDto> findAllTicketHistory();
    public TicketHistoryGridDto updateTicketStatusCompleted(String id, TicketHistoryDto updateTicketHistory);
    public List<TicketGridDto> findAllTicketByDate(String date);
    public List<TicketGridDto> findAllTicketByStatus(String status);
    public List<TicketGridDto> findAllTicketOrderByUrgency(String urgency);

}
