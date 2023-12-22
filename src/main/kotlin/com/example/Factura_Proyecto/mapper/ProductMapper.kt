package com.example.Factura_Proyecto.mapper

import com.example.Factura_Proyecto.dto.ProductDto
import com.example.Factura_Proyecto.model.Product

object ProductMapper {
    fun mapToDto (product: Product) : ProductDto {

        return  ProductDto(
            product.id,
            "${product.description} ${product.brand}"

        )
    }
}