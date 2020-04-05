package com.wsb.tickets.controller;

import com.wsb.tickets.domain.Operator;
import com.wsb.tickets.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @PostMapping
    public Operator saveOperator(@RequestBody Operator operator) {
        return operatorService.save(operator);
    }

    @GetMapping("/id/{id}")
    public Operator getOperator(@PathVariable Long id) { // PathVariable - zmienna będzie pobierana z linku
        return operatorService.getById(id);
    }

    @GetMapping
    public Page<Operator> operatorPage(@RequestParam Integer page, @RequestParam Integer size) {
        // jak daję RequestParam to w linku podaję ?page=0&size=10
        return operatorService.getPage(PageRequest.of(page, size));
    }

    @DeleteMapping
    public void removeOperator(@RequestParam Long id) {
        operatorService.removeOperator(id);
    }

    @PutMapping
    public Operator editOperator(@RequestBody Operator operator) {
        return operatorService.editOperator(operator);
    }
}
