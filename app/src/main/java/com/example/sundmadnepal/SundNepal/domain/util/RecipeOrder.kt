package com.example.sundmadnepal.SundNepal.domain.util

sealed class RecipeOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): RecipeOrder(orderType)
    class Id(orderType: OrderType): RecipeOrder(orderType)
}