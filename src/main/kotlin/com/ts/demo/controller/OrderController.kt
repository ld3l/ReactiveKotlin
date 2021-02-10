package com.ts.demo.controller

import com.ts.demo.domain.Order
import com.ts.demo.service.OrderService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController()
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping("/orders/{id}")
    fun getOrderByNumber(@PathVariable id: Int): Mono<Order> = orderService.getOrderByOrderNumber(id)

}

