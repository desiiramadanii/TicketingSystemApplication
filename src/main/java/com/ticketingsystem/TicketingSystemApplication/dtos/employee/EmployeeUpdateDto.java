package com.ticketingsystem.TicketingSystemApplication.dtos.employee;

import com.ticketingsystem.TicketingSystemApplication.models.Employee;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class EmployeeUpdateDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String phone;

    public Employee convert(){
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));
        return new Employee(
                firstName,
                lastName,
                LocalDate.parse(birthDate, formatTgl),
                phone);
    }
}
