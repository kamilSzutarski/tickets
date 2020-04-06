package com.wsb.tickets.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(unique = true)
    private String topic;
    private Integer priority;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "ticketHeader")
    private List<TicketElement> elementList = new LinkedList<>();

    @JsonBackReference
    @ManyToOne
    private Operator operator;

}
