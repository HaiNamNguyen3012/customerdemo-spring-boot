package com.example.customerdemo.service;

import com.example.customerdemo.common.CommonStatus;
import com.example.customerdemo.common.ResourceNotFoundException;
import com.example.customerdemo.dto.CustomerDTO;
import com.example.customerdemo.dto.CustomerProjection;
import com.example.customerdemo.model.Customer;
import com.example.customerdemo.repository.CustomerRepository;
import com.example.customerdemo.service.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    //Lấy detail của khách hàng
    public CustomerDTO getCustomerByCustomerNumber(Long customerNumber){
        Optional<Customer> customer = customerRepository.findById(customerNumber);
        if(!customer.isPresent()) throw new ResourceNotFoundException("Không tồn tại khách hàng");
        CustomerDTO customerDTO = customerMapper.toDTO(customer.get());
        return customerDTO;
    }

    //Lấy danh sách khách hàng theo tên và quốc tịch
    public List<CustomerProjection> getAllCustomerByNameAndCountry(String country, String city){
        return customerRepository.findCustomersByCountry(country, city);
    }

    //Thêm khách hàng

    //Sửa khách hàng
    public CommonStatus updateCustomer()
    //Xóa khách hàng
}
