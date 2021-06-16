package com.example.mapping.dao;


import com.example.mapping.dto.OrderResponse;
import com.example.mapping.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.example.mapping.dto.OrderResponse(c.cname , p.pname) FROM customer c JOIN c.product p")
    public List<OrderResponse> getJoinInformation();
}
