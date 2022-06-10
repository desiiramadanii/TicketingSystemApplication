package com.ticketingsystem.TicketingSystemApplication.services;

import com.ticketingsystem.TicketingSystemApplication.dataEnum.StatusTicket;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeUpdateDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketGridDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketInsertDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketUpdateDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory.TicketHistoryDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory.TicketHistoryGridDto;
import com.ticketingsystem.TicketingSystemApplication.models.Ticket;
import com.ticketingsystem.TicketingSystemApplication.models.TicketHistory;
import com.ticketingsystem.TicketingSystemApplication.repositories.TicketHistoryRepository;
import com.ticketingsystem.TicketingSystemApplication.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketGridDto.oneTicket;

@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private TicketHistoryRepository ticketHistoryRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketHistoryRepository ticketHistoryRepository){
        this.ticketRepository = ticketRepository;
        this.ticketHistoryRepository = ticketHistoryRepository;
    }

    //findAllTicket
    public List<TicketGridDto> findAllTicket(){
        Stream<Ticket> ticketStream = ticketRepository.findAll().stream();
        return TicketGridDto.toList(ticketStream.collect(Collectors.toList()));
    }

    //findTicketById
    public TicketGridDto findTicketById(String id){
        return oneTicket(ticketRepository.getById(id));
    }

    //insertTicket
    public TicketGridDto insertTicket(TicketInsertDto newTicket){
        boolean ticket = ticketRepository.findById(newTicket.getId()).isPresent();
        if(ticket){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID Ticket sudah ada");
        }
        return TicketGridDto.set(ticketRepository.save(newTicket.convert()));
    }

    //updateTicket
    public TicketGridDto updateTicketById(String id, TicketUpdateDto updateTicket){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket tidak ditemukan"));

        ticket.setTitle(updateTicket.getTitle());
        ticket.setDetails(updateTicket.getDetails());
        ticket.setDueDate(updateTicket.convert().getDueDate());
        ticket.setUrgency(updateTicket.getUrgency());

        ticketRepository.save(ticket);
        return TicketGridDto.set(ticket);
    }

    //deleteTicket
    public TicketGridDto deleteTicketById(String id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket tidak ditemukan"));
        ticketRepository.deleteById(id);
        return TicketGridDto.set(ticket);
    }

    //updateTicketStatusCanceled
    public TicketGridDto updateTicketStatusCanceled(String id){
        Ticket newStatusTicket = ticketRepository.getById(id);
        newStatusTicket.setStatus("CANCELED");
        ticketRepository.save(newStatusTicket);
        return oneTicket(ticketRepository.getById(newStatusTicket.getId()));
    }

    //findTicketHistory
    public List<TicketHistoryGridDto> findAllTicketHistory(){
        Stream<TicketHistory> ticketHistoryStream = ticketHistoryRepository.findAll().stream();
        return TicketHistoryGridDto.toList(ticketHistoryStream.collect(Collectors.toList()));
    }

    //updateTicketStatusCompleted
    public TicketHistoryGridDto updateTicketStatusCompleted(String id, TicketHistoryDto updateTicketHistory){
        Ticket newStatusTicket = ticketRepository.getById(id);
        TicketHistory ticketHistory = updateTicketHistory.convert(newStatusTicket);
        ticketHistoryRepository.save(ticketHistory);
        newStatusTicket.setStatus(StatusTicket.COMPLETED.name());
        ticketRepository.save(newStatusTicket);
        return TicketHistoryGridDto.set(ticketHistory);
    }

    //findTicketByYear
    public List<TicketGridDto> findAllTicketByDate(String date){
        Stream<Ticket> ticketStream = ticketRepository.findAllTicketByDate(date).stream();
        return TicketGridDto.toList(ticketStream.collect(Collectors.toList()));
    }

    //findTicketByStatus
    public List<TicketGridDto> findAllTicketByStatus(String status){
        Stream<Ticket> ticketStream = ticketRepository.findAllTicketByStatus(status).stream();
        return TicketGridDto.toList(ticketStream.collect(Collectors.toList()));
    }

    //findTicketOrderByUrgency
    public List<TicketGridDto> findAllTicketOrderByUrgency(String urgency){
        Stream<Ticket> ticketStream = ticketRepository.findAllTicketOrderByUrgency(urgency).stream();
        return TicketGridDto.toList(ticketStream.collect(Collectors.toList()));
    }

}
