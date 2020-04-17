package com.douglasborba.nybooks.presentation.books.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.nybooks.data.model.BooksModel
import kotlinx.android.synthetic.main.item_book.view.*

class BooksViewHolder(itemView: View, private val onItemClickListener: (book: BooksModel) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.text_title
    private val author = itemView.text_author

    fun bind(book: BooksModel){
        title.text = book.title
        author.text = book.author

        itemView.setOnClickListener {
            onItemClickListener.invoke(book)
        }
    }
}