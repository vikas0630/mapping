package com.example.mapping.controller;



import com.example.mapping.dao.CustomerDao;
import com.example.mapping.dao.ProductDao;
import com.example.mapping.dto.OrderRequest;
import com.example.mapping.dto.OrderResponse;
import com.example.mapping.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ProductDao productDao;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerDao.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerDao.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerDao.getJoinInformation();
    }
}