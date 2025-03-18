package com.example.employeedb3.service;

import com.example.employeedb3.dto.*;
import com.example.employeedb3.entity.Address;
import com.example.employeedb3.entity.Education;
import com.example.employeedb3.entity.Employee;
import com.example.employeedb3.exception.EmployeeFoundException;
import com.example.employeedb3.exception.EmployeeNotFoundException;
import com.example.employeedb3.exception.InvalidCredentialsException;
import com.example.employeedb3.repository.AddressRepo;
import com.example.employeedb3.repository.EducationRepo;
import com.example.employeedb3.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private EducationRepo educationRepo;

    @Override
    @Transactional
    public EmployeeResponseDTO2 addEmp(EmployeeRequestDTO employeeRequestDTO) {

//        Employee save = repo.save(employee);
        // EmployeeResponseDTO2 dto2 = new EmployeeResponseDTO2();
        // BeanUtils.copyProperties(save, dto2);
//        List<AddressRequestDto> addressListDto = employeeRequestDTO.getAddress();
//        List<Address> addressList = addressListDto.stream().map(addressRequestDto -> {
//            Address address = new Address();
//            BeanUtils.copyProperties(addressRequestDto, address);
//            return address;
//        }).toList();
//        employee.setAddresses(addressList);
//        Employee savedEmployee = repo.save(employee);
//        EmployeeResponseDTO2 employeeResponseDTO = new EmployeeResponseDTO2();
//        BeanUtils.copyProperties(employee, employeeResponseDTO);
//        List<Address> addresses = savedEmployee.getAddresses();
//        List<AddressResponseDto> addressResponseDtosList = addresses.stream().map(address -> {
//            AddressResponseDto addressResponseDto = new AddressResponseDto();
//            BeanUtils.copyProperties(address, addressResponseDto);
//            return addressResponseDto;
//        }).toList();
//        employeeResponseDTO.setAddressResponseDtos(addressResponseDtosList);
        Optional<Employee> byEmail = repo.findByEmail(employeeRequestDTO.getEmail());
        if (byEmail.isPresent()) {
            throw new EmployeeFoundException("employee already exists");
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDTO, employee);
        Employee savedEmployee = repo.save(employee);
        List<AddressRequestDto> addressRequestDtoList = employeeRequestDTO.getAddress();
        List<Address> addressList = addressRequestDtoList.stream().map(addressRequestDto -> {
            Address address = new Address();
            BeanUtils.copyProperties(addressRequestDto, address);
            address.setEmployee(savedEmployee);
            return address;
        }).toList();
        addressRepo.saveAll(addressList);
        EmployeeResponseDTO2 employeeResponseDTO2 = new EmployeeResponseDTO2();
        BeanUtils.copyProperties(savedEmployee,employeeResponseDTO2);
        List<AddressResponseDto> addressResponseDtos = addressList.stream().map(address -> {
            AddressResponseDto addressResponseDto = new AddressResponseDto();
            BeanUtils.copyProperties(address, addressResponseDto);
            return addressResponseDto;
        }).toList();
        employeeResponseDTO2.setAddressResponseDtos(addressResponseDtos);

        List<EducationRequestDto> educationRequestDtos=employeeRequestDTO.getEducation();
        List<Education> educationList = educationRequestDtos.stream().map(educationRequestDto -> {
            Education education = new Education();
            BeanUtils.copyProperties(educationRequestDto, education);
            education.setEmployee(savedEmployee);
            return education;
        }).toList();
        educationRepo.saveAll(educationList);
        List<EducationResponseDto> educationResponseDtoList = educationList.stream().map(education -> {
            EducationResponseDto educationResponseDto = new EducationResponseDto();
            BeanUtils.copyProperties(education, educationResponseDto);
            return educationResponseDto;
        }).toList();
        employeeResponseDTO2.setEducation(educationResponseDtoList);
        return employeeResponseDTO2;
    }

    @Override
    public List<EmployeeResponseDTO2> getAllEmployee() {
        List<Employee> emplist = repo.findAll();
        List<EmployeeResponseDTO2> dtoList = new ArrayList<>();
        for (Employee employee : emplist) {
            EmployeeResponseDTO2 dto = new EmployeeResponseDTO2();
            BeanUtils.copyProperties(employee, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public String deleteEMployee(String email, String password) {
        Employee employee = repo.findByEmail(email).orElseThrow(() -> new EmployeeNotFoundException("the given email don't exists"));

        if (employee.getPassword().equals(password)) {
            repo.delete(employee);
            return "Deleted successfully";
        } else {
            throw new InvalidCredentialsException("wrong credentials ");
        }
    }


    @Override
    public String addByEmail(EmployeeRequestDTO employeeRequestDTO) {

        Optional<Employee> byEmail = repo.findByEmail(employeeRequestDTO.getEmail());

        if (byEmail.isEmpty()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeRequestDTO, employee);
            repo.save(employee);
            return "employee added successfully";
        } else {
            throw new EmployeeFoundException("the employee alreaddy exists");
        }

    }

    @Override
    public EmployeeResponseDTO2 updateEmployeeByEmail(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = repo.findByEmail(employeeRequestDTO.getEmail()).orElseThrow(() -> new InvalidCredentialsException("you have entered wrong credentials"));
        BeanUtils.copyProperties(employeeRequestDTO, employee);
        Employee updatedEmployee = repo.save(employee);
        EmployeeResponseDTO2 dto2 = new EmployeeResponseDTO2();
        BeanUtils.copyProperties(updatedEmployee, dto2);

        return dto2;

    }

    @Override
    public EmployeeResponseDTO2 loginEmployee(String email, String password) {
        Employee employee = repo.findByEmail(email).orElseThrow(() -> new EmployeeNotFoundException("the given email don't exists"));

        if (employee.getPassword().equals(password)) {
            EmployeeResponseDTO2 dto2 = new EmployeeResponseDTO2();
            BeanUtils.copyProperties(employee, dto2);
            return dto2;

        } else {
            throw new InvalidCredentialsException("invalid credentials");
        }

    }

    @Override
    public EmployeeResponseDTO2 fetchEmployee(String email) {
        Employee employee = repo.findByEmail(email).orElseThrow(() -> new EmployeeNotFoundException("employee email is not valid"));
        EmployeeResponseDTO2 dto2 = new EmployeeResponseDTO2();
        BeanUtils.copyProperties(employee, dto2);
        return dto2;
    }
}


