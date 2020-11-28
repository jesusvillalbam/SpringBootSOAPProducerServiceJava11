package com.jesusvillalbam.springboot.soapproducerservice.domain.service;

import com.jesusvillalbam.demo_web_service.Ticket;

public interface TicketService {

    Ticket getTicket(Integer ticketId);

    Ticket saveTicket(Ticket ticket);
}
