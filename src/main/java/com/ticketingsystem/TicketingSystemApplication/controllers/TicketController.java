package com.ticketingsystem.TicketingSystemApplication.controllers;

import com.ticketingsystem.TicketingSystemApplication.dtos.RestResponse;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketGridDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketInsertDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticket.TicketUpdateDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory.TicketHistoryDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.ticketHistory.TicketHistoryGridDto;
import com.ticketingsystem.TicketingSystemApplication.services.TicketService;
import com.ticketingsystem.TicketingSystemApplication.services.TicketServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketServiceImplementation ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping("getAllTicket")
    public ResponseEntity<RestResponse<List<TicketGridDto>>> findAllTicket(){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.findAllTicket(),
                        "Data Tiket Berhasil Ditemukan",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("getTicketById/{id}")
    public ResponseEntity<RestResponse<TicketGridDto>> findTicketById(@PathVariable String id){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.findTicketById(id),
                        "Data Berhasil Ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<TicketGridDto>> insertNewTicket(@RequestBody TicketInsertDto newTicket){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.insertTicket(newTicket),
                        "Data Ticket Berhasil Ditambahkan",
                        200),
                HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<TicketGridDto>> updateTicket(@PathVariable String id, @RequestBody TicketUpdateDto updateTicket){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.updateTicketById(id, updateTicket),
                        "Data Ticket Berhasil Diupdate",
                        200),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<TicketGridDto>> deleteTicket(@PathVariable String id){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.deleteTicketById(id),
                        "Data Ticket Berhasil Dihapus",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("getAllTicketHistory")
    public ResponseEntity<RestResponse<List<TicketHistoryGridDto>>> findAllTicketHistory(){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.findAllTicketHistory(),
                        "Data Seluruh Tiket History Berhasil Ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PutMapping("updateCanceled/{id}")
    public ResponseEntity<RestResponse<TicketGridDto>> updateCanceled(@PathVariable String id){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.updateTicketStatusCanceled(id),
                        "Data Ticket Berhasil Diubah Menjadi Canceled",
                        200),
                HttpStatus.OK);
    }

    @PutMapping("updateCompleted/{id}")
    public ResponseEntity<RestResponse<TicketHistoryGridDto>> updateTicketStatusCompleted(@PathVariable String id, @RequestBody TicketHistoryDto updateTicketHistory){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.updateTicketStatusCompleted(id, updateTicketHistory),
                        "Data History Ticket Berhasil Berubah Menjadi COMPLETE",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("get-all-date/{date}")
    public ResponseEntity<RestResponse<List<TicketGridDto>>> findAllTicketByDate(@PathVariable String date){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.findAllTicketByDate(date),
                        "Data Tiket History Berdasarkan Due Date Berhasil Ditemukan",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("get-all-status/{status}")
    public ResponseEntity<RestResponse<List<TicketGridDto>>> findAllTicketHistoryByStatus(@PathVariable String status){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.findAllTicketByStatus(status),
                        "Data Tiket History Berdasarkan Status Berhasil Ditemukan",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("get-all-urgency/{urgency}")
    public ResponseEntity<RestResponse<List<TicketGridDto>>> findAllTicketHistoryByUrgency(@PathVariable String urgency){
        return new ResponseEntity<>(
                new RestResponse<>(
                        ticketService.findAllTicketOrderByUrgency(urgency),
                        "Data Tiket History Berdasarkan Urgency Berhasil Ditemukan",
                        200),
                HttpStatus.OK);
    }



}
