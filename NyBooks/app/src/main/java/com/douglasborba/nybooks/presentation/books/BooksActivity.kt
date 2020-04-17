package com.douglasborba.nybooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.nybooks.R
import com.douglasborba.nybooks.presentation.books.adapter.BooksAdapter
import com.douglasborba.nybooks.presentation.books.viewmodel.BooksViewModel
import com.douglasborba.nybooks.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbar_main.title = getString(R.string.toolbar_name)
        setSupportActionBar(toolbar_main)

        val viewModel: BooksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, Observer {
            it?.let { books ->
                with(recycler_books){
                    layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    // ao implementar o adapter a callback do click em lambda é usada
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getStartIntent(this@BooksActivity, book.title, book.description)
                        this@BooksActivity.startActivity(intent)
                    }
                }
            }
        })

        viewModel.getBooks()

    }
}
