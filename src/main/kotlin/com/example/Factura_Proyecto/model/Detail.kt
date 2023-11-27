package com.example.Factura_Proyecto.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal

@Table(name = "detail")
@Entity
class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "quantity")
    var quantity: Int? = null

    @Column(name = "price", precision = 10, scale = 2)
    var price: BigDecimal? = null

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    var invoice_id: Invoice? = null

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    var product_id: Product? = null
}