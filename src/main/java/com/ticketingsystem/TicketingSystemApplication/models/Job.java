package com.ticketingsystem.TicketingSystemApplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JobId", nullable = false)
    private Integer id;

    @Column(name = "Title", nullable = false, length = 50)
    private String title;

    @OneToMany(mappedBy = "jobID")
    private Set<Employee> employees = new LinkedHashSet<>();

    public Job(Integer id) {
        this.id = id;
    }

}