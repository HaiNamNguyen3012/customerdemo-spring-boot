package com.example.customerdemo.service.mapper;

import com.example.customerdemo.dto.CustomerDTO;
import com.example.customerdemo.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
}
