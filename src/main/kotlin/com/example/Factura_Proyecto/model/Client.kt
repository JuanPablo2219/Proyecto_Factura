package com.example.Factura_Proyecto.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

@Table(name = "client")
@Entity
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    var nui: String? = null

    @NotNull(message = "El campo FULLNAME es obligatorio")
    var fullname: String? = null

    @NotNull(message = "El campo ADRESS es obligatorio")
    var adress: String? = null
}