package com.jesusvillalbam.springboot.soapproducerservice.service.endpoint;

import com.jesusvillalbam.demo_web_service.GetTicketRequest;
import com.jesusvillalbam.demo_web_service.GetTicketRespose;
import com.jesusvillalbam.demo_web_service.SaveTicketRequest;
import com.jesusvillalbam.demo_web_service.SaveTicketRespose;
import com.jesusvillalbam.demo_web_service.Ticket;
import com.jesusvillalbam.springboot.soapproducerservice.domain.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TicketEndpoint {

    private static final String NAMESPACE_URI = "http://jesusvillalbam.com/demo-web-service";


    @Autowired
    TicketService ticketService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTicketRequest")
    @ResponsePayload
    public GetTicketRespose getTicket(@RequestPayload GetTicketRequest getTicketRequest) {
        GetTicketRespose getTicketRespose = new GetTicketRespose();
        getTicketRespose.setTicket(ticketService.getTicket(getTicketRequest.getTicketId()));
        return getTicketRespose;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveTicketRequest")
    @ResponsePayload
    public SaveTicketRespose saveTicket(@RequestPayload SaveTicketRequest saveTicketRequest) {
        SaveTicketRespose saveTicketRespose = new SaveTicketRespose();
        Ticket ticket = new Ticket();
        ticket.setResumen(saveTicketRequest.getResumen());
        ticket.setDescripcion(saveTicketRequest.getDescripcion());
        ticket.setSolucion(saveTicketRequest.getResumen());
        ticket.setEstado(saveTicketRequest.getDescripcion());
        saveTicketRespose.setTicket(ticketService.saveTicket(ticket));
        return saveTicketRespose;
    }
}
