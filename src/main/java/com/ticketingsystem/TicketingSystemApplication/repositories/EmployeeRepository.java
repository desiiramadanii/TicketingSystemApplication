package com.ticketingsystem.TicketingSystemApplication.repositories;

import com.ticketingsystem.TicketingSystemApplication.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = """
            SELECT * from Employee
            WHERE JobID = 2;
            """, nativeQuery = true)
    List<Employee> getAllTechSup();

    @Query(value = """
            SELECT * from Employee
            WHERE EmployeeID like CONCAT('T', '%') and exists (select AppointedTo from Ticket where Employee.EmployeeID = Ticket.AppointedTo)
            """, nativeQuery = true)
    List<Employee> getEmployeeByTechSupWorking();

    @Query(value = """
            SELECT * from Employee
            WHERE EmployeeID like CONCAT('T', '%') and not exists (select AppointedTo from Ticket where Employee.EmployeeID = Ticket.AppointedTo)
            """, nativeQuery = true)
    List<Employee> getEmployeeByTechSupNotWork();
}