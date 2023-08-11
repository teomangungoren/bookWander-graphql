package com.bookWander.lib.service

import com.bookWander.lib.dto.AuthorDto
import com.bookWander.lib.dto.CreateAuthorRequest
import com.bookWander.lib.exception.AuthorNotFoundException
import com.bookWander.lib.model.Author
import com.bookWander.lib.repository.AuthorRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AuthorService(private val authorRepository: AuthorRepository) {

    fun createAuthor(createAuthorRequest: CreateAuthorRequest): AuthorDto {
        val createdAuthor = Author(
            "",
            createAuthorRequest.name,
            createAuthorRequest.surname,
            null,
        )
        return AuthorDto.convert(authorRepository.save(createdAuthor))
    }

    fun findAuthorById(id: String): Author {
        return authorRepository.findAuthorById(id)
            ?: throw AuthorNotFoundException("customer with the ID $id could not be found ")
    }

    fun findAuthorDtoById(id: String): AuthorDto {
        val author = authorRepository.findAuthorById(id)
            ?: throw AuthorNotFoundException("customer with the ID $id could not be found ")
        return AuthorDto.convert(author)
    }

    fun getAllAuthors(): List<AuthorDto> {
        return authorRepository.findAll()
            .stream()
            .map(AuthorDto::convert)
            .collect(Collectors.toList())
    }
}
