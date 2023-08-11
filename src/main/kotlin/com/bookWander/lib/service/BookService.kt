package com.bookWander.lib.service

import com.bookWander.lib.dto.BookDto
import com.bookWander.lib.dto.CreateBookRequest
import com.bookWander.lib.exception.BookNotFoundException
import com.bookWander.lib.model.Book
import com.bookWander.lib.repository.BookRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BookService(private val bookRepository: BookRepository, private val authorService: AuthorService) {

    fun getAllBooks(): List<BookDto> {
        return bookRepository.findAll()
            .stream()
            .map(BookDto::convert)
            .collect(Collectors.toList())
    }

    fun createBook(authorId: String, createBookRequest: CreateBookRequest): BookDto {
        val author = authorService.findAuthorById(authorId)
        val book = Book("", createBookRequest.title, createBookRequest.pages, author, createBookRequest.category)
        return BookDto.convert(bookRepository.save(book))
    }

    fun getBookById(bookId: String): BookDto {
        val book = bookRepository.findBookById(bookId)
            ?: throw BookNotFoundException("book with the ID $bookId could not be found ")
        return BookDto.convert(book)
    }
}
