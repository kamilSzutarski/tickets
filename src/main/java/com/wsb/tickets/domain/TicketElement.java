package com.wsb.tickets.domain;

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


    @ManyToOne(cascade = CascadeType.ALL)
    private TicketHeader ticketHeader;

}
