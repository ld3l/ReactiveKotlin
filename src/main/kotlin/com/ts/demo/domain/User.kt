package com.ts.demo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User (@Id var id: Int = 0,
                 var name: String = "")