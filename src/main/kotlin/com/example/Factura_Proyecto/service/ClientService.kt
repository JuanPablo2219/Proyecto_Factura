package com.example.Factura_Proyecto.service

import com.example.Factura_Proyecto.model.Client
import com.example.Factura_Proyecto.repository.ClientRepository
import com.example.Factura_Proyecto.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun list(): List<Client> {
        return clientRepository.findAll()
    }

    fun listById(id: Long?): Client? {
        return clientRepository.findById(id)
    }

    fun save(client: Client): Client {
        try {
            client.fullname?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El campo Nombres no debe ser vacio")
            client.adress?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El campo Ciudad no debe ser vacio")

            return clientRepository.save(client)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(client: Client): Client{
        try {
            clientRepository.findById(client.id)
                ?: throw Exception("ID no existe")

            return clientRepository.save(client)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(client: Client): Client {
        //try {
        clientRepository.findById(client.id)
            ?: throw Exception("ID no existe")
        return clientRepository.save(client)
        //} catch (ex: Exception) {
        //   throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        //  }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = clientRepository.findById(id)
                ?: throw Exception("ID no existe")
            clientRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}