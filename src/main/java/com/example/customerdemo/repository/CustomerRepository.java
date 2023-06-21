package com.example.customerdemo.repository;

import com.example.customerdemo.dto.CustomerProjection;
import com.example.customerdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByCustomerNumber(@Param("customerNumber") Long customerNumber);

    @Modifying //dùng khi update hoặc delete
    @Query(nativeQuery = true, value = "SELECT c.customer_number as customerNumber, c.customer_name as customerName, c.phone as customerPhone, c.city as customerCity, c.country as customerCountry FROM customers c WHERE (:country is null or c.country like concat('%', :country, '%')) AND (:city is null or c.city like concat('%', :city, '%'))")
    List<CustomerProjection> findCustomersByCountry(@Param("country") String country, @Param("city") String city);
}
