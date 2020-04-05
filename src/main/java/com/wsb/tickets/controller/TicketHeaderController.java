package com.wsb.tickets.controller;

import com.wsb.tickets.domain.TicketHeader;
import com.wsb.tickets.service.TicketHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticketHeader")
public class TicketHeaderController {

    @Autowired
    TicketHeaderService ticketHeaderService;

    @PostMapping
    public TicketHeader saveTicketHeader(@RequestBody TicketHeader ticketHeader) {
        return ticketHeaderService.save(ticketHeader);
    }

    @GetMapping("/id/{id}")
    public TicketHeader getTicketHeader(@PathVariable Long id) { // PathVariable - zmienna będzie pobierana z linku
        return ticketHeaderService.getById(id);
    }

    @GetMapping
    public Page<TicketHeader> ticketHeaderPage(@RequestParam Integer page, @RequestParam Integer size) {
        // jak daję RequestParam to w linku podaję ?page=0&size=10
        return ticketHeaderService.getPage(PageRequest.of(page, size));
    }

    @DeleteMapping
    public void removeTicketHeader(@RequestParam Long id) {
        ticketHeaderService.removeTicketHeader(id);
    }

    @PutMapping
    public TicketHeader editTicketHeader(@RequestBody TicketHeader ticketHeader) {
        return ticketHeaderService.editTicketHeader(ticketHeader);
    }

    @GetMapping("/priority/{priority}/{page}/{size}")
    public Page<TicketHeader> findByPriorityContaining(@PathVariable Integer priority, @PathVariable Integer page, @PathVariable Integer size) {
        return ticketHeaderService.findByPriorityContaining(priority, PageRequest.of(page, size));
    }

    @GetMapping("/topic/{topic}")
    public Page<TicketHeader> findByTopicContaining(@PathVariable String topic, @RequestParam Integer page, @RequestParam Integer size) {
        return ticketHeaderService.findByTopicContaining(topic, PageRequest.of(page, size));
    }

    @GetMapping("/operator/{name}")
    public Page<TicketHeader> findByOperatorNameContaining(@PathVariable String name, @RequestParam Integer page, @RequestParam Integer size) {
        return ticketHeaderService.findByOperatorNameContaining(name, PageRequest.of(page, size));
    }
}
