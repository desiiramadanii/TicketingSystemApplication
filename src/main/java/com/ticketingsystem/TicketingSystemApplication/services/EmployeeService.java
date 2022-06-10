package com.ticketingsystem.TicketingSystemApplication.services;

import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeGridDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeInsertDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeUpdateDto;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeGridDto> findAllEmployee();
    public EmployeeGridDto insertEmployee(EmployeeInsertDto newEmployee);
    public EmployeeGridDto updateEmployeeById(String id, EmployeeUpdateDto updateEmployee);
    public EmployeeGridDto deleteEmployeeById(String id);
    public List<EmployeeGridDto> findAllTs();
    public List<EmployeeGridDto> findAllTsWorking();
    public List<EmployeeGridDto> findAllTsNotWork();

}
