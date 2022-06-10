package com.ticketingsystem.TicketingSystemApplication.dtos.employee;

import com.ticketingsystem.TicketingSystemApplication.models.Employee;
import com.ticketingsystem.TicketingSystemApplication.models.Job;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class EmployeeInsertDto implements Serializable {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String phone;
    private final Integer jobId;

    public Employee convert() {
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        return new Employee(
                id,
                firstName,
                lastName,
                LocalDate.parse(birthDate, formatTgl),
                phone,
                jobId
        );
    }

}
