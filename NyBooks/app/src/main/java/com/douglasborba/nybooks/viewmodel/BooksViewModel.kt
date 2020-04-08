package com.douglasborba.nybooks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.douglasborba.nybooks.data.model.BooksModel

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<BooksModel>> = MutableLiveData()

    fun getBooks() {
        booksLiveData.value = createFakeBooks()
    }

    private fun createFakeBooks(): List<BooksModel> {
        return listOf(
            BooksModel("Title 1", "Author 1"),
            BooksModel("Title 2", "Author 2"),
            BooksModel("Title 3", "Author 3")
        )
    }
}