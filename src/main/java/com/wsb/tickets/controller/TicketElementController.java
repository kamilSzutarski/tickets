package com.wsb.tickets.controller;

import com.wsb.tickets.domain.TicketElement;
import com.wsb.tickets.service.TicketElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticketElement")
public class TicketElementController {

    @Autowired
    TicketElementService ticketElementService;

    @PostMapping
    public TicketElement saveTicketElement(@RequestBody TicketElement ticketElement) {
        return ticketElementService.save(ticketElement);
    }

    @GetMapping("/id/{id}")
    public TicketElement getTicketElement(@PathVariable Long id) { // PathVariable - zmienna będzie pobierana z linku
        return ticketElementService.getById(id);
    }

    @GetMapping
    public Page<TicketElement> ticketElementPage(@RequestParam Integer page, @RequestParam Integer size) {
        // jak daję RequestParam to w linku podaję ?page=0&size=10
        return ticketElementService.getPage(PageRequest.of(page, size));
    }

    @DeleteMapping
    public void removeTicketElement(@RequestParam Long id) {
        ticketElementService.removeTicketElement(id);
    }

    @PutMapping
    public TicketElement editTicketHeader(@RequestBody TicketElement ticketElement) {
        return ticketElementService.editTicketElement(ticketElement);
    }
}
