package com.example.Factura_Proyecto.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Table(name = "product")
@Entity
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @NotNull(message = "El campo DESCRIPTION es obligatorio")
    var description: String? = null

    @NotNull(message = "El campo DESCRIPTION es obligatorio")
    var brand: String? = null

    var price: BigDecimal? = null

    var stock: Int? = null
}