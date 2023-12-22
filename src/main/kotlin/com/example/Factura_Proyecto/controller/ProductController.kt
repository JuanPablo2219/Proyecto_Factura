package com.example.Factura_Proyecto.controller

import com.example.Factura_Proyecto.dto.ProductDto
import com.example.Factura_Proyecto.model.Product
import com.example.Factura_Proyecto.service.InvoiceService
import com.example.Factura_Proyecto.service.ProductService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list ():List <Product> {
        return productService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(productService.listById(id), HttpStatus.OK)
    }

    @GetMapping("/product-dto")
    fun listTdo (): ResponseEntity<*> {
        return ResponseEntity(productService.listDto(), HttpStatus.OK)
    }


    @PostMapping
    fun save (@RequestBody @Valid product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.save(product), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.update(product), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.updateName(product), HttpStatus.OK)
    }

    @DeleteMapping("/product/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return productService.delete(id)
    }
    }