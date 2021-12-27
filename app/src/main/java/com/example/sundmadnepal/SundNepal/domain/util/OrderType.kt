package com.example.sundmadnepal.SundNepal.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}