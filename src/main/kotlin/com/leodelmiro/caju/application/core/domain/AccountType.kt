package com.leodelmiro.caju.application.core.domain

enum class AccountType(private val mcc: Set<String>) {
    FOOD(setOf("5411", "5412")),
    MEAL(setOf("5811", "5812")),
    CASH(setOf());

    fun mccToAccountType(mcc: String) {
        when {
            FOOD.mcc.contains(mcc) -> FOOD
            MEAL.mcc.contains(mcc) -> MEAL
            else -> CASH
        }
    }
}