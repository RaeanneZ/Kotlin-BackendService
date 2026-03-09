package com.example.demo.service

import com.example.demo.dto.ServiceCardRequest
import com.example.demo.dto.ServiceCardResponse
import com.example.demo.exception.NotFoundException
import com.example.demo.mapper.toResponse
import com.example.demo.model.ServiceCard
import com.example.demo.repository.ServiceCardRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


// This should return data objects, not ResponseEntity.
// @Service (DI): Spring Boot scans the project, sees ServiceCardRepository, and injects it automatically into the service constructor.
@Service
class ServiceCardService( private val serviceCardRepository: ServiceCardRepository) {

    fun create(serviceCardRequest: ServiceCardRequest): ResponseEntity<ServiceCardResponse> {
        val entity = ServiceCard(
            title = serviceCardRequest.title.trim(),
            category = serviceCardRequest.category.trim(),
            tags = serviceCardRequest.tags.map { it.trim() }.filter { it.isNotBlank() },
            description = serviceCardRequest.description.trim()
        )

        val saved = serviceCardRepository.save(entity)

        return  ResponseEntity.ok(saved.toResponse())
    }

    fun getAll(): List<ServiceCardResponse> =
        serviceCardRepository.findAll().map { it.toResponse() }

    fun getById(id: String): ServiceCardResponse {
        val card = serviceCardRepository.findById(id).orElseThrow {
            NotFoundException("ServiceCard not found: $id")
        }
        return card.toResponse()
    }

    fun update(id: String, req: ServiceCardRequest): ServiceCardResponse {
        val existing = serviceCardRepository.findById(id).orElseThrow {
            NotFoundException("ServiceCard not found: $id")
        }

        val updated = existing.copy(
            title = req.title.trim(),
            category = (req.category ?: existing.category).trim(),
            tags = req.tags.map { it.trim() }.filter { it.isNotBlank() },
            description = req.description.trim(),
        )

        return serviceCardRepository.save(updated).toResponse()
    }

    fun delete(id: String) {
        if (!serviceCardRepository.existsById(id)) {
            throw NotFoundException("ServiceCard not found: $id")
        }
        serviceCardRepository.deleteById(id)
    }
}