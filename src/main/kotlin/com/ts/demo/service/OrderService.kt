package com.ts.demo.service

import com.ts.demo.domain.Order
import com.ts.demo.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.onErrorReturn
import java.lang.RuntimeException

@Service
class OrderService(
    private val orderRepo: OrderRepository
) {
    fun addOrderToUser(order: Order, id: Int): Mono<Order> {
        order.userId = id
        return orderRepo.save(order)
    }

    suspend fun getAllOrdersByUserId(id: Int): Flow<Order> {
        return orderRepo.findAllByUserId(id)
    }

    suspend fun getOrderByOrderNumber(order_num:Int):Flow<Order> = orderRepo.findByOrderNumber(order_num)


}