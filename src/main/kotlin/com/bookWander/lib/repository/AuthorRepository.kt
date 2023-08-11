package com.bookWander.lib.repository

import com.bookWander.lib.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, String> {
    fun findAuthorById(id: String): Author?
}
