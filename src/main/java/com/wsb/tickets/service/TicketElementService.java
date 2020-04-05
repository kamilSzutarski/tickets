package com.wsb.tickets.service;

import com.wsb.tickets.domain.TicketElement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public interface TicketElementService {

    TicketElement save(TicketElement ticketElement);

    TicketElement getById(Long id);

    Page<TicketElement> getPage(@PageableDefault Pageable pageable);

    void removeTicketElement(Long id);

    TicketElement editTicketElement(TicketElement ticketElement);
}
