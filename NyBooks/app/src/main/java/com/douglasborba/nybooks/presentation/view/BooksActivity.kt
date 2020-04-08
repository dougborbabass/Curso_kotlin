package com.douglasborba.nybooks.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.nybooks.R
import com.douglasborba.nybooks.data.model.BooksModel
import com.douglasborba.nybooks.presentation.view.adapter.BooksAdapter
import com.douglasborba.nybooks.viewmodel.BooksViewModel
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbar_main.title = getString(R.string.toolbar_name)
        setSupportActionBar(toolbar_main)

        val viewModel: BooksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, Observer {
            it?.let {books ->
                with(recycler_books){
                    layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books)
                }
            }
        })

        viewModel.getBooks()

    }
}
