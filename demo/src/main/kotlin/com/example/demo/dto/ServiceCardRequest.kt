package com.example.demo.dto

import java.time.Instant

// Represents how data is stored in MongoDB.
data class ServiceCardRequest(
    val id: String?,
    val title: String,
    val category: String = "service",
    val tags: List<String> = emptyList(),
    val description: String,
)
