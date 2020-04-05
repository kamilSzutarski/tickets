package com.wsb.tickets.repository;

import com.wsb.tickets.domain.TicketElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketElementRepository extends JpaRepository<TicketElement, Long> {
}
