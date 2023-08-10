package com.bookWander.lib.controller

import com.bookWander.lib.dto.BookDto
import com.bookWander.lib.dto.CreateBookRequest
import com.bookWander.lib.service.BookService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BookController(private val bookService: BookService) {
    @QueryMapping
    fun getAllBooks():List<BookDto>{
        return bookService.getAllBooks();
    }

    @QueryMapping
    fun getBookById(@Argument id:String): BookDto {
        return bookService.getBookById(id);
    }

    @MutationMapping
    fun createBook(@Argument id:String, @Argument createBookRequest: CreateBookRequest):BookDto {
        return bookService.createBook(id,createBookRequest);
    }
}