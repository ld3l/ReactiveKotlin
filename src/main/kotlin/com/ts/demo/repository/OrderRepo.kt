package com.ts.demo.repository

import com.ts.demo.domain.Order
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface OrderRepository : ReactiveCrudRepository<Order, Int> {
   suspend fun findAllByUserId(userId: Int): Flow<Order>;
   suspend fun findByOrderNumber(orderNumber: Int): Flow<Order>
}