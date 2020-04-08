package com.douglasborba.nybooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.nybooks.R
import com.douglasborba.nybooks.data.model.BooksModel
import com.douglasborba.nybooks.presentation.books.adapter.BooksAdapter
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbar_main.title = getString(R.string.toolbar_name)
        setSupportActionBar(toolbar_main)

        with(recycler_books){
            layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = BooksAdapter(getBooks())
        }
    }

    fun getBooks(): List<BooksModel> {
        return listOf<BooksModel>(
            BooksModel("Title 1", "Author 1"),
            BooksModel("Title 2", "Author 2"),
            BooksModel("Title 3", "Author 3")
        )
    }
}
