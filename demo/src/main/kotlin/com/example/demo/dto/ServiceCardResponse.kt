package com.example.demo.dto

// What the frontend (React) receives.
data class ServiceCardResponse(
    val id: String,
    val title: String,
    val category: String,
    val tags: List<String>,
    val description: String,
)