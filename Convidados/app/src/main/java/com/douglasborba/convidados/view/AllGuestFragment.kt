package com.douglasborba.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.convidados.R
import com.douglasborba.convidados.view.adapter.GuestAdapter
import com.douglasborba.convidados.viewmodel.AllGuestsViewModel
import kotlinx.android.synthetic.main.fragment_all_guest.*
import kotlinx.android.synthetic.main.fragment_all_guest.view.*

class AllGuestFragment : Fragment() {

    private lateinit var homeViewModel: AllGuestsViewModel

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_guest, container, false)

        // 1 - obter o recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        // 2 - definir um layout
        recycler.layoutManager = LinearLayoutManager(root.context)

        // 3 - definir um adapter
        recycler.adapter = GuestAdapter()

        return root
    }
}
