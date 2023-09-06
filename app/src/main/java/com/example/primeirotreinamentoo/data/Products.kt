package com.example.primeirotreinamentoo.data

import androidx.annotation.StringRes
import com.example.primeirotreinamentoo.R

data class Products(
    @StringRes val name: Int,
    val price: Float,
    @StringRes val brand: Int
)

val products = listOf(
    Products(R.string.product1, 10.79f, R.string.brand1),
    Products(R.string.product2, 17.14f, R.string.brand2),
    Products(R.string.product3, 23.80f, R.string.brand3),
    Products(R.string.product4, 3.35f, R.string.brand4),
    Products(R.string.product5, 12.50f, R.string.brand5),
    Products(R.string.product6, 14.50f, R.string.brand6)
)


