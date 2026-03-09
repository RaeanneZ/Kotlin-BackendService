package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// Represents one MongoDB document in service_cards
// @Id is the Mongo _id field
@Document(collection = "service_cards")
data class ServiceCard(
    @Id
    val id: String? = null,

    val title: String,
    val category: String = "service",          // like your screenshot header "service"
    val tags: List<String> = emptyList(),      // e.g. ["Experimental", "Go"]
    val description: String,
)
