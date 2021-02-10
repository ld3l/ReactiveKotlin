package com.ts.demo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("orders")
data class Order (@Id var id: Int = 0,
                 var orderNumber:Int =0,
                 var description: String = "",
                 var userId:Int)