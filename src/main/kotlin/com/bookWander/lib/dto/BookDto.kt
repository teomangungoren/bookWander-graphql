package com.bookWander.lib.dto

import com.bookWander.lib.model.Book
import com.bookWander.lib.model.Category
import java.math.BigDecimal

data class BookDto(
    val id: String?,
    val title: String?,
    val pages: BigDecimal?,
    val author: AuthorDto?,
    val category: Category?,
) {

    companion object {
        @JvmStatic
        fun convert(from: Book): BookDto {
            return BookDto(
                from.id,
                from.title,
                from.pages,
                AuthorDto.convert(from.author!!),
                from.category,
            )
        }
    }
}
