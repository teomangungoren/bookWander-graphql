package com.bookWander.lib.exception

import graphql.ErrorType
import graphql.GraphQLError
import graphql.GraphqlErrorBuilder
import graphql.schema.DataFetchingEnvironment
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter
import org.springframework.stereotype.Component

@Component
class GraphqlException : DataFetcherExceptionResolverAdapter() {

    protected override fun resolveToSingleError(ex: Throwable, env: DataFetchingEnvironment): GraphQLError? {
        if (ex is AuthorNotFoundException || ex is BookNotFoundException) {
            return toGraphqlError(ex)
        } else if (ex is Exception) {
            return toGraphqlError(ex)
        }
        return super.resolveToSingleError(ex, env)
    }

    private fun toGraphqlError(throwable: Throwable): GraphQLError {
        return GraphqlErrorBuilder.newError()
            .message(throwable.message)
            .errorType(ErrorType.DataFetchingException)
            .build()
    }
}
