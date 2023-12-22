package com.example.Factura_Proyecto.repository

import com.example.Factura_Proyecto.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Long?> {
    fun findById (id: Long?): Client?

}