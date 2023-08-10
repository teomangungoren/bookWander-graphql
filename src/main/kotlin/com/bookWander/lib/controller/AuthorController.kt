package com.bookWander.lib.controller

import com.bookWander.lib.dto.AuthorDto
import com.bookWander.lib.dto.CreateAuthorRequest
import com.bookWander.lib.service.AuthorService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class AuthorController(private val authorService: AuthorService) {

    @QueryMapping
    fun getAllAuthors():List<AuthorDto>{
        return authorService.getAllAuthors();
    }

    @QueryMapping
    fun getAuthorById(@Argument id:String):AuthorDto{
        return authorService.findAuthorDtoById(id);
    }

    @MutationMapping
    fun createAuthor(@Argument createAuthorRequest: CreateAuthorRequest):AuthorDto{
        return authorService.createAuthor(createAuthorRequest);

    }
}