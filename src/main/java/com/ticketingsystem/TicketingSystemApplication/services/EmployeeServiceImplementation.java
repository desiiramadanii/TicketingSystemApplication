package com.ticketingsystem.TicketingSystemApplication.services;

import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeGridDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeInsertDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeUpdateDto;
import com.ticketingsystem.TicketingSystemApplication.models.Employee;
import com.ticketingsystem.TicketingSystemApplication.repositories.EmployeeRepository;
import com.ticketingsystem.TicketingSystemApplication.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private static EmployeeRepository employeeRepository;
    private static JobRepository jobRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    //findAllEmployee
    @Override
    public List<EmployeeGridDto> findAllEmployee(){
        Stream<Employee> employeeStream = employeeRepository.findAll().stream();
        return EmployeeGridDto.toList(employeeStream.collect(Collectors.toList()));
    }

    //insertEmployee
    @Override
    public EmployeeGridDto insertEmployee(EmployeeInsertDto newEmployee){
        boolean employee = employeeRepository.findById(newEmployee.getId()).isPresent();
        if(employee){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID Employee sudah ada");
        }
        return EmployeeGridDto.set(employeeRepository.save(newEmployee.convert()));
    }

    //updateEmployee
    @Override
    public EmployeeGridDto updateEmployeeById(String id, EmployeeUpdateDto updateEmployee){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan"));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setBirthDate(updateEmployee.convert().getBirthDate());
        employee.setPhone(updateEmployee.getPhone());

        employeeRepository.save(employee);
        return EmployeeGridDto.set(employee);
    }

    //deleteEmployee
    @Override
    public EmployeeGridDto deleteEmployeeById(String id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan"));
        employeeRepository.deleteById(id);
        return EmployeeGridDto.set(employee);
    }

    //findAllTS
    @Override
    public List<EmployeeGridDto> findAllTs(){
        Stream<Employee> employeeStream = employeeRepository.getAllTechSup().stream();
        return EmployeeGridDto.toList(employeeStream.collect(Collectors.toList()));
    }

    //findAllTSWorking
    @Override
    public List<EmployeeGridDto> findAllTsWorking(){
        Stream<Employee> employeeStream = employeeRepository.getEmployeeByTechSupWorking().stream();
        return EmployeeGridDto.toList(employeeStream.collect(Collectors.toList()));
    }

    //findAllTSNotWorking
    @Override
    public List<EmployeeGridDto> findAllTsNotWork(){
        Stream<Employee> employeeStream = employeeRepository.getEmployeeByTechSupNotWork().stream();
        return EmployeeGridDto.toList(employeeStream.collect(Collectors.toList()));
    }
}
