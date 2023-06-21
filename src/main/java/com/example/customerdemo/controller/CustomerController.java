package com.example.customerdemo.controller;


import com.example.customerdemo.common.CommonStatus;
import com.example.customerdemo.common.ResourceNotFoundException;
import com.example.customerdemo.dto.CustomerDTO;
import com.example.customerdemo.dto.CustomerProjection;
import com.example.customerdemo.model.Customer;
import com.example.customerdemo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {
    private  final CustomerService customerService;

    //Lấy khách hàng theo ID
    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerDTO> getCustomerByCustomerNumber(@PathVariable Long customerNumber){
        return ResponseEntity.ok(customerService.getCustomerByCustomerNumber(customerNumber));
    }

    //Lấy danh sách khách hàng theo nước và thành phố
    @GetMapping("")
    public ResponseEntity<List<CustomerProjection>> getAllCustomerByNameAndCountry(@RequestParam(required = false) String country, @RequestParam(required = false) String city){
        return ResponseEntity.ok(customerService.getAllCustomerByNameAndCountry(country, city));
    }

    //Sửa thông tin khách hàng
    @PutMapping("")
    public ResponseEntity<CommonStatus> updateCustomer(@RequestBody CustomerDTO customerDTO){
        if(customerDTO.getCustomerNumber() == null) throw new ResourceNotFoundException("Không tìm thấy khách hàng");

    }
}
