package com.example.Factura_Proyecto.repository

import com.example.Factura_Proyecto.model.Client
import com.example.Factura_Proyecto.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ProductRepository : JpaRepository<Product, Long?> {
    fun findById(id: Long?): Product?
}