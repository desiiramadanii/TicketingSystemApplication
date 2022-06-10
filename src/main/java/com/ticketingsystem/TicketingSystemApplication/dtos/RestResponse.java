package com.ticketingsystem.TicketingSystemApplication.dtos;

import lombok.Data;

@Data
public class RestResponse<T> {
    private final T data;
    private final String message;
    private final int status;
}
