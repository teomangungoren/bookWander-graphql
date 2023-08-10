package com.bookWander.lib.dto

import com.bookWander.lib.model.Author
import java.util.stream.Collectors

data class AuthorDto(
    val id:String?,
    val name:String?,
    val surname:String?,
    val books:Set<BookDto>?
) {
    companion object {
        @JvmStatic
        fun convert(from: Author): AuthorDto {
            val bookDtos=if(from.books!=null){
                from.books.stream()
                    .map(BookDto::convert)
                    .collect(Collectors.toSet())
            }else{
                emptySet()
            }
            return AuthorDto(
                from.id,
                from.name,
                from.surname,
                bookDtos
            )
        }
    }

}
