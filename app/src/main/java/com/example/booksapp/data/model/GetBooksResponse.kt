package com.example.booksapp.data.model

data class GetBooksResponse(
    val success:Int?,
    val message:String?,
    val books:List<Book>?

)
