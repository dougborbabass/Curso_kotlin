package com.douglasborba.nybooks.presentation.books.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.nybooks.R
import com.douglasborba.nybooks.data.model.BooksModel
import com.douglasborba.nybooks.presentation.books.viewholder.BooksViewHolder

class BooksAdapter(private val books: List<BooksModel>) : RecyclerView.Adapter<BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)

        return BooksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.count()
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(books[position])
    }
}