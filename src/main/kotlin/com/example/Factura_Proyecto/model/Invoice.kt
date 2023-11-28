package com.example.Factura_Proyecto.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

@Table(name = "invoice")
@Entity
class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @NotNull(message = "El campo CODE es obligatorio")
    var code: String? = null

    @Column(name = "create_at")
    var create_at: LocalDate? = null

    var total: BigDecimal? = null

    var client_id: Long? = null

    // Relación con Detail [es una relación inversa, extrae datos de detail con los que tiene relacion en 'invoice_id']
//    @OneToMany(mappedBy = "invoice_id", cascade = [CascadeType.ALL], orphanRemoval = true)
//    var details: List<Detail> = mutableListOf()
}