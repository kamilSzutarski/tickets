package com.wsb.tickets.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketHeader extends Auditable<String> {

    @Id
    @GeneratedValue
    private Long id;

    private String topic;
    private Integer priority;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "ticketHeader")
    private List<TicketElement> elementList = new LinkedList<>();

    @ManyToOne
    private Operator operator;

}
