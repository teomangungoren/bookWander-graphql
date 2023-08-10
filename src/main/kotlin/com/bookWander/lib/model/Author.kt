package com.bookWander.lib.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
data class Author(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String?,
    val name:String?,
    val surname:String?,

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    val books:Set<Book>?=HashSet()
)
{


}
