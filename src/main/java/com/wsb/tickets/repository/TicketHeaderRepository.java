package com.wsb.tickets.repository;

import com.wsb.tickets.domain.TicketHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketHeaderRepository extends JpaRepository<TicketHeader, Long> {

    Page<TicketHeader> findByTopicContaining(String topic, Pageable pageable);

    Page<TicketHeader> findByPriorityContaining(Integer priority, Pageable pageable);

    Page<TicketHeader> findByOperatorNameContaining(String name, Pageable pageable);
}
