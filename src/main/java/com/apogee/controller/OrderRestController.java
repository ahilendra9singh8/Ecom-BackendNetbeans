package com.apogee.controller;

import com.apogee.payload.ApiResponse;
import com.apogee.payload.OrderDto;
import com.apogee.payload.OrderRequest;
import com.apogee.payload.OrderResponse;
import com.apogee.services.OrderService;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;
    //create order 

//    http://localhost:8080/EcomBack/order/createOrder/
//    {
//    "orderAddress":"Gwalior",
//    "cartId":"1"
//}
    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequest orderReq, Principal p) {
        String username = p.getName();
        OrderDto order = this.orderService.orderCreate(orderReq, username);
        return new ResponseEntity<OrderDto>(order, HttpStatus.CREATED);
    }

//    http://localhost:8080/EcomBack/order/cancelOrderById/1
    @DeleteMapping("/cancelOrderById/{orderId}")
    public ResponseEntity<?> cancelOrderById(@PathVariable int orderId) {
        this.orderService.CancelOrder(orderId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Order deleted", true), HttpStatus.OK);
    }

//http://localhost:8080/EcomBack/order/findById/2
    @GetMapping("/findById/{orderId}")
    public ResponseEntity<OrderDto> findById(@PathVariable int orderId) {
        OrderDto orderDto = this.orderService.findById(orderId);
        return new ResponseEntity<OrderDto>(orderDto, HttpStatus.ACCEPTED);
    }

//    http://localhost:8080/EcomBack/order/findAllOrders/findAll?pageSize=1&pageNumber=0
    @GetMapping("/findAllOrders/findAll")
    public OrderResponse findAllOrders(
            @RequestParam(defaultValue = "2", value = "pageSize") int pageSize,
            @RequestParam(defaultValue = "0", value = "pageNumber") int pageNumber
    ) {
        OrderResponse findAllOrders = this.orderService.findAllOrders(pageNumber, pageSize);

        return findAllOrders;
    }
}
