package com.ticketingsystem.TicketingSystemApplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "EmployeeID", nullable = false, length = 3)
    private String id;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "BirthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "Phone", nullable = false, length = 15)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "JobID", nullable = false)
    private Job jobID;

    @OneToMany(mappedBy = "appointedTo")
    private Set<Ticket> ticketsAppointed = new LinkedHashSet<>();

    @OneToMany(mappedBy = "createdBy")
    private Set<Ticket> ticketsCreated = new LinkedHashSet<>();

    @OneToMany(mappedBy = "approvedBy")
    private Set<TicketHistory> ticketHistories = new LinkedHashSet<>();

    public Employee(String id, String firstName, String lastName, LocalDate birthDate, String phone, Integer jobId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.jobID = new Job(jobId);
    }

    public Employee(String firstName, String lastName, LocalDate birthDate, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public String fetchFullName(){
        return String.format("%s %s", this.firstName, this.lastName == null ? "" : this.lastName);
    }

    public Employee(String id) {
        this.id = id;
    }

}