package com.jesusvillalbam.springboot.soapproducerservice.domain.service.impl;

import com.jesusvillalbam.demo_web_service.Ticket;
import com.jesusvillalbam.springboot.soapproducerservice.domain.service.TicketService;
import com.jesusvillalbam.springboot.soapproducerservice.infraestructure.persistence.entity.TicketEntity;
import com.jesusvillalbam.springboot.soapproducerservice.infraestructure.persistence.repository.TicketRepository;
import com.jesusvillalbam.springboot.soapproducerservice.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket getTicket(Integer ticketId) {
        TicketEntity ticketEntity = ticketRepository.findById(ticketId).orElse(null);
        if (null == ticketEntity)
            throw new NotFoundException("Ticket Not Found");

        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketEntity.getTicketId());
        ticket.setResumen(ticketEntity.getResumen());
        ticket.setDescripcion(ticketEntity.getDescripcion());
        ticket.setSolucion(ticketEntity.getSolucion());
        ticket.setEstado(ticketEntity.getEstado());

        return ticket;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        TicketEntity ticketEntity = TicketEntity.builder()
                .resumen(ticket.getResumen())
                .descripcion(ticket.getDescripcion())
                .solucion(ticket.getSolucion())
                .estado(ticket.getEstado())
                .build();

        ticketEntity = ticketRepository.save(ticketEntity);

        Ticket ticketResponse = new Ticket();
        ticketResponse.setTicketId(ticketEntity.getTicketId());
        ticketResponse.setResumen(ticketEntity.getResumen());
        ticketResponse.setDescripcion(ticketEntity.getDescripcion());
        ticketResponse.setSolucion(ticketEntity.getSolucion());
        ticketResponse.setEstado(ticketEntity.getEstado());

        return ticketResponse;
    }
}
