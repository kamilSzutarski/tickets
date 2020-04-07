package com.wsb.tickets.service.impl;

import com.wsb.tickets.domain.TicketHeader;
import com.wsb.tickets.repository.OperatorRepository;
import com.wsb.tickets.repository.TicketElementRepository;
import com.wsb.tickets.repository.TicketHeaderRepository;
import com.wsb.tickets.service.TicketHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class TicketHeaderServiceImpl implements TicketHeaderService {

    @Autowired
    private TicketHeaderRepository ticketHeaderRepository;

    @Autowired
    private TicketElementRepository ticketElementRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public TicketHeader save(TicketHeader ticketHeader) {
        ticketHeader.setOperator(operatorRepository.findByLogin(ticketHeader.getOperator().getLogin()).orElseThrow(() -> new EntityNotFoundException("Login not found")));
        return ticketHeaderRepository.save(ticketHeader);
    }

    @Override
    public TicketHeader getById(Long id) {
        return ticketHeaderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket with id: " + id + " is not found"));
    }

    @Override
    public Page<TicketHeader> getPage(Pageable pageable) {
        return ticketHeaderRepository.findAll(pageable);
    }

    @Override
    public Page<TicketHeader> findByTopicContaining(String topic, Pageable pageable) {
        return ticketHeaderRepository.findByTopicContaining(topic, pageable);
    }

    @Override
    public Page<TicketHeader> findByOperatorNameContaining(String name, Pageable pageable) {
        return ticketHeaderRepository.findByOperatorNameContaining(name, pageable);
    }

    @Override
    public Page<TicketHeader> findByPriorityContaining(Integer priority, Pageable pageable) {
        return ticketHeaderRepository.findByPriorityContaining(priority, pageable);
    }

    @Override
    public void removeTicketHeader(Long id) {
        ticketHeaderRepository.deleteById(id);
    }

    // TODO operator
    @Override
    public TicketHeader editTicketHeader(TicketHeader ticketHeader) {
        return ticketHeaderRepository.findById(ticketHeader.getId()).map(ticketDB -> {
            if (!ticketDB.getPriority().equals(ticketHeader.getPriority())
                    || (!ticketDB.getTopic().equals(ticketHeader.getTopic()))) {
                ticketDB.setPriority(ticketHeader.getPriority());
                ticketDB.setTopic(ticketHeader.getTopic());
            }
            return ticketHeaderRepository.save(ticketDB);
        })
                .orElseThrow(() -> new EntityNotFoundException("Product with id doesn't exist"));
    }
}
