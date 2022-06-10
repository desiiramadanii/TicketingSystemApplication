package com.ticketingsystem.TicketingSystemApplication.dtos.employee;

import com.ticketingsystem.TicketingSystemApplication.models.Employee;
import lombok.Data;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class EmployeeGridDto implements Serializable {
    private final String id;
    private final String fullName;
    private final String birthDate;
    private final String phone;
    private final String title;

    public static List<EmployeeGridDto> toList(List<Employee> employees){
        List<EmployeeGridDto> result = new ArrayList<>();

        for (Employee employee: employees
        ) {
            result.add(set(employee));
        }
        return result;
    }

    public static EmployeeGridDto set(Employee employee) {
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        return new EmployeeGridDto(
                employee.getId(),
                employee.fetchFullName(),
                employee.getBirthDate().format(formatTgl),
                employee.getPhone(),
                employee.getJobID().getTitle()
        );
    }
}
