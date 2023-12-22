package com.example.Factura_Proyecto.service

import com.example.Factura_Proyecto.model.Detail
import com.example.Factura_Proyecto.repository.DetailRepository
import com.example.Factura_Proyecto.repository.InvoiceRepository
import com.example.Factura_Proyecto.repository.ProductRepository
import jakarta.persistence.Id
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun list(): List<Detail> {
        return detailRepository.findAll()
    }

    fun listById(id: Long?): Detail? {
        return detailRepository.findById(id)
    }

    @Transactional
    fun save(detail: Detail): Detail {
        try {
            val detailSave = detailRepository.save(detail)
            val listDetail = detailRepository.findByInvoiceId(detail.invoiceId)
            val invoiceToUp = invoiceRepository.findById(detail.invoiceId)
            var sum = 0.0
                listDetail.forEach{
                    sum += it.price * it.quantity
                }
            val product = productRepository.findById(detail.productId)
                ?: throw Exception("ID product no exist")
            invoiceToUp?.apply {
                total = sum
            }

            product.apply{
                stock = stock?.minus(detail.quantity)
            }
            //productRepository.save(product)
            //calculateAndUpdateTotal(detailSave)
            return detailSave
        }

        catch (ex: Exception) {
           throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(detail: Detail): Detail{
        val productUpdate = productRepository.findById(detail.productId)
            ?:throw Exception("No exist the id the product")
        invoiceRepository.findById(detail.invoiceId)
            ?:throw Exception("No exist the id the Invoice")
        val oldQuantity = detailRepository.findById(detail.id)?.quantity;

        try {
            detailRepository.findById(detail.id)
                ?: throw Exception("ID no exist")
            if(oldQuantity != null) {
                productUpdate.apply {
                    stock = stock?.plus(oldQuantity - detail.quantity);
                }
            }
            return detailRepository.save(detail)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(detail: Detail): Detail {
        //try {
        detailRepository.findById(detail.id)
            ?: throw Exception("ID no existe")
        return detailRepository.save(detail)
        //} catch (ex: Exception) {
        //   throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        //  }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val detailToDelete = detailRepository.findById(id)
                ?: throw Exception("ID no existe")
            val product = productRepository.findById(detailToDelete.productId)
                ?: throw Exception("ID product no exist")
            product.apply{
                stock = stock?.plus(detailToDelete.quantity)
            }
            detailRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}