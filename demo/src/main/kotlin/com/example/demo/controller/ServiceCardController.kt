package com.example.demo.controller

import com.example.demo.dto.ServiceCardRequest
import com.example.demo.dto.ServiceCardResponse
import com.example.demo.model.ServiceCard
import com.example.demo.service.ServiceCardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

// Controller returns ResponseEntity because it’s the HTTP layer.
@RestController
@RequestMapping("/api/service-cards")
class ServiceCardController(
    private val service: ServiceCardService
) {
    @PostMapping // POST /api/service-cards
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody req: ServiceCardRequest): ResponseEntity<ServiceCardResponse> =
        service.create(req)

    @GetMapping // GET /api/service-cards
    fun getAll(): List<ServiceCardResponse> =
        service.getAll()

    @GetMapping("/{id}") // GET /api/service-cards/{id}
    fun getById(@PathVariable id: String): ServiceCardResponse =
        service.getById(id)

    @PutMapping("/{id}") // PUT /api/service-cards/{id}
    fun update(@PathVariable id: String, @RequestBody req: ServiceCardRequest): ServiceCardResponse =
        service.update(id, req)

    @DeleteMapping("/{id}") // DELETE /api/service-cards/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }
}
