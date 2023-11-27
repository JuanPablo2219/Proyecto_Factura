package com.example.Factura_Proyecto.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDateTime

@Table(name = "invoice")
@Entity
class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @NotNull(message = "El campo CODE es obligatorio")
    @Column(name = "code", unique = true, nullable = false, length = 30)
    var code: String? = null

    @Column(name = "create_at")
    var create_at: LocalDateTime? = null

    @Column(name = "total", precision = 10, scale = 2)
    var total: BigDecimal? = null

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    var client: Client? = null

    // Relación con Detail [es una relación inversa, extrae datos de detail con los que tiene relacion en 'invoice_id']
    @OneToMany(mappedBy = "invoice_id", cascade = [CascadeType.ALL], orphanRemoval = true)
    var details: List<Detail> = mutableListOf()
}