package com.wsb.tickets.service;

import com.wsb.tickets.domain.TicketHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public interface TicketHeaderService {

    TicketHeader save(TicketHeader ticketHeader);

    TicketHeader getById(Long id);

    Page<TicketHeader> getPage(@PageableDefault Pageable pageable);

    Page<TicketHeader> findByTopicContaining(String topic, Pageable pageable);

    Page<TicketHeader> findByOperatorNameContaining(String name, Pageable pageable);

    Page<TicketHeader> findByPriorityContaining(Integer priority, Pageable pageable);

    void removeTicketHeader(Long id);

    TicketHeader editTicketHeader(TicketHeader ticketHeader);
}
