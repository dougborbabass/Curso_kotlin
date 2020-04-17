package com.douglasborba.nybooks.data.response

import com.douglasborba.nybooks.data.model.BooksModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDetailsResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "author")
    val author: String,
    @Json(name = "description")
    val description: String
) {
    fun getBookModel() = BooksModel(
        title = this.title,
        author = this.author,
        description = this.description
    )
}