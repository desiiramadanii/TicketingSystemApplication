package com.ticketingsystem.TicketingSystemApplication.controllers;

import com.ticketingsystem.TicketingSystemApplication.dtos.RestResponse;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeGridDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeInsertDto;
import com.ticketingsystem.TicketingSystemApplication.dtos.employee.EmployeeUpdateDto;
import com.ticketingsystem.TicketingSystemApplication.services.EmployeeService;
import com.ticketingsystem.TicketingSystemApplication.services.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImplementation employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("getAllEmployee")
    public ResponseEntity<RestResponse<List<EmployeeGridDto>>> findAllEmployee(){
        return new ResponseEntity<>(
                new RestResponse<>(employeeService.findAllEmployee(),
                "Data Employee Berhasil Ditemukan", 200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<EmployeeGridDto>> insertEmployee(@RequestBody EmployeeInsertDto newEmployee){
        return new ResponseEntity<>(
                new RestResponse<>(employeeService.insertEmployee(newEmployee),
                "Data Employee Berhasil Ditambah", 200),
                HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<EmployeeGridDto>> updateEmployee(@PathVariable String id, @RequestBody EmployeeUpdateDto updateEmployee){
        return new ResponseEntity<>(
                new RestResponse<>(employeeService.updateEmployeeById(id, updateEmployee),
                "Data Employee Berhasil Diupdate", 200),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<EmployeeGridDto>> delete(@PathVariable String id){
        return new ResponseEntity<>(
                new RestResponse<>(
                        employeeService.deleteEmployeeById(id),
                        "Data Employee Berhasil Dihapus",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("get-all-ts")
    public ResponseEntity<RestResponse<List<EmployeeGridDto>>> findAllEmployeeTs(){
        return new ResponseEntity<>(
                new RestResponse<>(employeeService.findAllTs(),
                "Data Employee Technical Support Berhasil Ditemukan", 200),
                HttpStatus.OK);
    }

    @GetMapping("get-all-ts-working")
    public ResponseEntity<RestResponse<List<EmployeeGridDto>>> findAllEmployeeTsWorking(){
        return new ResponseEntity<>(
                new RestResponse<>(employeeService.findAllTsWorking(),
                "Data Employee Technical Support Yang Sedang Bekerja Berhasil Ditemukan", 200),
                HttpStatus.OK);
    }

    @GetMapping("get-all-ts-not-work")
    public ResponseEntity<RestResponse<List<EmployeeGridDto>>> findAllEmployeeTsNotWork(){
        return new ResponseEntity<>(
                new RestResponse<>(employeeService.findAllTsNotWork(),
                "Data Employee Technical Support Yang Tidak Bekerja Berhasil Ditemukan", 200),
                HttpStatus.OK);
    }

}
