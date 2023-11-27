package com.example.Factura_Proyecto.service

import com.example.Factura_Proyecto.model.Product
import com.example.Factura_Proyecto.repository.DetailRepository
import com.example.Factura_Proyecto.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var detailRepository: DetailRepository

    fun list(): List<Product> {
        return productRepository.findAll()
    }

    fun listById(id: Long?): Product? {
        return productRepository.findById(id)
    }

    fun save(product: Product): Product {
        try {
            product.description?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El campo description no debe ser vacio")
            product.brand?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El campo brand no debe ser vacio")

            return productRepository.save(product)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(product: Product): Product{
        try {
            productRepository.findById(product.id)
                ?: throw Exception("ID no existe")

            return productRepository.save(product)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(product: Product): Product {
        //try {
        productRepository.findById(product.id)
            ?: throw Exception("ID no existe")
        return productRepository.save(product)
        //} catch (ex: Exception) {
        //   throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        //  }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = productRepository.findById(id)
                ?: throw Exception("ID no existe")
            productRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}