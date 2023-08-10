package com.bookWander.lib.repository

import com.bookWander.lib.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository:JpaRepository<Book,String> {
    fun findBookById(id:String):Book;
}