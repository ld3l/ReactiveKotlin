package com.ts.demo.controller

import com.ts.demo.domain.Order
import com.ts.demo.service.OrderService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.AdditionalMatchers.not
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.ArgumentMatchers.*

@WebFluxTest(UserController::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UserControllerTest {



    private lateinit var client: WebClient

    @MockBean
    var orderService:OrderService? = null

    @Autowired
    var controller:UserController?=null

    @BeforeAll
    fun initClient() {
//        runApplication<DemoApplication>()
        client = WebClient.create()
    }


    @Test
    fun getOrderByUser() {
       val orders: List<Order> = listOf(
           Order(1,1,"Test1",1),
           Order(2,2,"Test2",1)
       )
        Mockito.`when`(orderService!!.getAllOrdersByUserId(1)).thenReturn(Flux.fromIterable(orders))
        Mockito.`when`(orderService!!.getAllOrdersByUserId(not(eq(1)))).thenReturn(Flux.empty())

        StepVerifier.create(controller!!.getAllUserOrders(1)).expectNext(orders[0]).expectNext(orders[1]).expectComplete().verify()
        StepVerifier.create(controller!!.getAllUserOrders(2)).expectComplete().verify()


//        StepVerifier.create(client.get().uri("http://localhost:8080/user/1/orders").retrieve().bodyToFlux(Order::class.java)).expectNext(orders[0]).expectNext(orders[1]).expectComplete().verify()



    }

    @Test
    fun addOrderToUser() {
        TODO("Разобраться почему мок не создается")
       val orderToSave:Order = Order(1,1,"work:",14)
       val expectedOrder:Order = Order(1,1,"work:",1)
        Mockito.`when`(orderService!!.addOrderToUser(orderToSave, 1)!!.thenReturn(Mono.just(expectedOrder)))
        assertEquals(expectedOrder,controller!!.addOrderToUser(orderToSave,1))
    }
}