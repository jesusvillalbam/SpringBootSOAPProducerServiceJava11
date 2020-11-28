package com.jesusvillalbam.springboot.soapproducerservice.infraestructure.persistence.repository;

import com.jesusvillalbam.springboot.soapproducerservice.infraestructure.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

}
