package com.example.Factura_Proyecto.service

import com.example.Factura_Proyecto.model.Invoice
import com.example.Factura_Proyecto.repository.ClientRepository
import com.example.Factura_Proyecto.repository.InvoiceRepository
import jakarta.persistence.Id
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list(): List<Invoice> {
        return invoiceRepository.findAll()
    }

    // nuevo metodo clase 28/11/2023
    fun filterTotal(value:Double?): List<Invoice>? {
        return invoiceRepository.filterTotal(value)
    }

    fun filterClientInvoice(clientId: Long): List<Invoice>? {
        return invoiceRepository.filterClientInvoice(clientId)
    }

    fun listById(id: Long?): Invoice? {
        return invoiceRepository.findById(id)
    }

    fun save(invoice: Invoice): Invoice {
        try {
            invoice.code?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El campo Nombres no debe ser vacio")
            return invoiceRepository.save(invoice)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(invoice: Invoice): Invoice{
        try {
            invoiceRepository.findById(invoice.id)
                ?: throw Exception("ID no existe")

            return invoiceRepository.save(invoice)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(invoice: Invoice): Invoice {
        //try {
        invoiceRepository.findById(invoice.id)
            ?: throw Exception("ID no existe")
        return invoiceRepository.save(invoice)
        //} catch (ex: Exception) {
        //   throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        //  }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = invoiceRepository.findById(id)
                ?: throw Exception("ID no existe")
            invoiceRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}