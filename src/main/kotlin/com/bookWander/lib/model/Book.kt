package com.bookWander.lib.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal

@Entity
data class Book(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String?,
    val title:String?,
    val pages:BigDecimal?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val author:Author?,

    @Enumerated(EnumType.STRING)
    val category:Category?

)

