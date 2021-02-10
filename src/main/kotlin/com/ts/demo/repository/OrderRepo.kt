package com.ts.demo.repository

import com.ts.demo.domain.Order
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface OrderRepository : ReactiveCrudRepository<Order, Int> {
    fun findAllByUserId(id:Int): Flux<Order>;
    fun findByOrderNumber(number:Int): Mono<Order>
}