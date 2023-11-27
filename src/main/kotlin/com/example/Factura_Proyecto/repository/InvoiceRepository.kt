package com.example.Factura_Proyecto.repository

import com.example.Factura_Proyecto.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long?> {
    fun findById (id: Long?): Invoice?
}