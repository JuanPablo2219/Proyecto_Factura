package com.example.Factura_Proyecto.controller

import com.example.Factura_Proyecto.model.Detail
import com.example.Factura_Proyecto.service.DetailService
import com.example.Factura_Proyecto.service.ProductService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/detail")
class DetailController {
    @Autowired
    lateinit var detailService: DetailService

    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list ():List <Detail> {
        return detailService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(detailService.listById(id), HttpStatus.OK)
    }


    @PostMapping
    fun save (@RequestBody @Valid detail: Detail): ResponseEntity<Detail> {
        return ResponseEntity(detailService.save(detail), HttpStatus.OK)
    }



    @PutMapping
    fun update (@RequestBody detail: Detail): ResponseEntity<Detail> {
        return ResponseEntity(detailService.update(detail), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody detail: Detail): ResponseEntity<Detail> {
        return ResponseEntity(detailService.updateName(detail), HttpStatus.OK)
    }

    @DeleteMapping("/detail/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean? {
        return detailService.delete(id)
    }
    }