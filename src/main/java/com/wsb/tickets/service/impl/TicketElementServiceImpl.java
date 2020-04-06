package com.wsb.tickets.service.impl;

import com.wsb.tickets.domain.TicketElement;
import com.wsb.tickets.repository.TicketElementRepository;
import com.wsb.tickets.repository.TicketHeaderRepository;
import com.wsb.tickets.service.TicketElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class TicketElementServiceImpl implements TicketElementService {

    @Autowired
    TicketElementRepository ticketElementRepository;

    @Autowired
    TicketHeaderRepository ticketHeaderRepository;

    @Override
    public TicketElement save(TicketElement ticketElement) {
        ticketElement.setTicketHeader(ticketHeaderRepository.findById(ticketElement.getTicketHeader().getId()).orElseThrow(() -> new EntityNotFoundException("Ticket Header not found")));
        return ticketElementRepository.save(ticketElement);
    }

    @Override
    public TicketElement getById(Long id) {
        return ticketElementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Element with id: " + id + " is not found"));
    }

    @Override
    public Page<TicketElement> getPage(Pageable pageable) {
        return ticketElementRepository.findAll(pageable);
    }

    @Override
    public void removeTicketElement(Long id) {
        ticketElementRepository.deleteById(id);
    }

    @Override
    public TicketElement editTicketElement(TicketElement ticketElement) {
        return ticketElementRepository.findById(ticketElement.getId()).map(elementDB -> {
            if (!elementDB.getContent().equals(ticketElement.getContent())) {
                elementDB.setContent(ticketElement.getContent());
            }
            return ticketElementRepository.save(elementDB);
        })
                .orElseThrow(() -> new EntityNotFoundException("Element with id doesn't exist"));
    }
}
