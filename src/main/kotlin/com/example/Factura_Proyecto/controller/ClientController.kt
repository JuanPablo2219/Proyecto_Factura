package com.example.Factura_Proyecto.controller

import com.example.Factura_Proyecto.model.Client
import com.example.Factura_Proyecto.service.ClientService
import com.example.Factura_Proyecto.service.InvoiceService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController {
    @Autowired
    lateinit var clientService: ClientService

    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list ():List <Client> {
        return clientService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(clientService.listById(id), HttpStatus.OK)
    }

    @GetMapping("/{clientId}/invoice")
    fun filterClientInvoice (@PathVariable("clientId") clientId: Long ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.filterClientInvoice(clientId), HttpStatus.OK)
    }


    @PostMapping
    fun save (@RequestBody @Valid client: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.save(client), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.update(client), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.updateName(client), HttpStatus.OK)
    }

    @DeleteMapping("/client/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return clientService.delete(id)
    }
    }