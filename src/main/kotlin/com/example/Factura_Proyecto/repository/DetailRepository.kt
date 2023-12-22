package com.example.Factura_Proyecto.repository

import com.example.Factura_Proyecto.model.Client
import com.example.Factura_Proyecto.model.Detail
import com.example.Factura_Proyecto.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?> {
    fun findById (id: Long?): Detail?
    fun findByInvoiceId(invoiceId: Long?) : List<Detail>
    @Query(nativeQuery = true)
    fun bestProductSeller(@Param ("value") value: Long):List<Detail>?

    //@Query(nativeQuery =true)
   // fun sumTotal(@Param ("invoiceId") invoiceId: Long?): Double?
}