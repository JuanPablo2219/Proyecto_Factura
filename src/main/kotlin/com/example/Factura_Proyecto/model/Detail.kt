package com.example.Factura_Proyecto.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table
import java.math.BigDecimal

@Table(name = "detail")
@Entity
class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    var id: Long? = null

    var quantity: Int =0

    var price: Double = 0.0

    @JoinColumn(name = "invoice_id")
    var invoiceId: Long? = null

    @JoinColumn(name = "product_id")
    var productId: Long? = null
}