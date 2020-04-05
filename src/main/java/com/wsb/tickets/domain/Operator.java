package com.wsb.tickets.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operator extends Auditable<String> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Login is required")
    @Length(min = 3, max = 15, message = "Login must have 3-15 characters")
    private String login;

    @NotNull(message = "Password is required")
    @Length(min = 4, max = 70, message = "Password must have at least 4 characters")
    private String password;

    @NotNull(message = "Name is required")
    private String name;

    private String surname;

    private String company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operator")
    private List<TicketHeader> ticketHeaders;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable
    private Set<Role> roles;

    @ManyToOne
    private Department department;

}
