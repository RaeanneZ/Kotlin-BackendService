package com.example.demo.repository

import com.example.demo.model.ServiceCard
import org.springframework.data.mongodb.repository.MongoRepository

// Spring auto-generates CRUD methods: save(), findAll(), findById(), deleteById()
interface ServiceCardRepository : MongoRepository<ServiceCard, String>