package com.wsb.tickets.controller;

import com.wsb.tickets.domain.Operator;
import com.wsb.tickets.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @PostMapping
    public Operator saveOperator(@RequestBody @Valid Operator operator, @RequestParam String... roleList) {
        return operatorService.save(operator, roleList);
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

    @PutMapping //upate
    public Operator editOperator(@RequestBody Operator operator) {
        return operatorService.editOperator(operator);
    }
}
