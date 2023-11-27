package com.example.Factura_Proyecto.repository

import com.example.Factura_Proyecto.model.Client
import com.example.Factura_Proyecto.model.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?> {
    fun findById (id: Long?): Detail?
}