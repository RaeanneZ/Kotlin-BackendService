package com.example.demo.mapper

import com.example.demo.model.ServiceCard
import com.example.demo.dto.ServiceCardResponse

/**
 * A mapper is simply a piece of code that converts one type of object into another type of object.
 * Think of it as a translator between layers of your application.
 *
 * Example:
 * Database object  →  API response object
 * (ServiceCard)       (ServiceCardResponse)
 */
fun ServiceCard.toResponse(): ServiceCardResponse {
    return ServiceCardResponse(
        id = this.id ?: "",
        title = this.title,
        category = this.category,
        tags = this.tags,
        description = this.description
    )
}