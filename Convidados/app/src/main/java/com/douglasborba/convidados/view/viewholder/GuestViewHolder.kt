package com.douglasborba.convidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.convidados.R
import com.douglasborba.convidados.service.model.GuestModel
import kotlinx.android.synthetic.main.row_guest.view.*

class GuestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel){
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name
    }
}