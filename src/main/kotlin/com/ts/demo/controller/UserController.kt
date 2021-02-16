package com.ts.demo.controller

import com.ts.demo.domain.Order
import com.ts.demo.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController()
@RequestMapping("/user")
class UserController(
    private val orderService: OrderService
) {
//    @GetMapping("/{id}/orders")
//    fun getOrderByUser(@PathVariable id: Int): Flux<Order> {
//       return orderService.getAllOrdersByUserId(id)
//    }

    @GetMapping("/{id}/orders")
    fun getAllUserOrders(@PathVariable id: Int): Flux<Order> {
        return orderService.getAllOrdersByUserId(id);
    }

    @PostMapping("/{id}/orders")
    fun addOrderToUser(@RequestBody order: Order, @PathVariable id: Int): Mono<Order> =
       orderService.addOrderToUser(order, id)

}