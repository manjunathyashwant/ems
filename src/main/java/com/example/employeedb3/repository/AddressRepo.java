package com.example.employeedb3.repository;

import com.example.employeedb3.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {

}
