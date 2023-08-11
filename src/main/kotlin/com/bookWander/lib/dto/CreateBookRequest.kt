package com.bookWander.lib.dto

import com.bookWander.lib.model.Category
import java.math.BigDecimal

data class CreateBookRequest(
    val authorId: String,
    val title: String,
    val pages: BigDecimal,
    val category: Category,
)
