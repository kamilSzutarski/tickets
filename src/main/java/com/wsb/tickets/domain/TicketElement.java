package com.wsb.tickets.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketElement {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String content;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private TicketHeader ticketHeader;

}
