package com.douglasborba.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.convidados.R
import com.douglasborba.convidados.view.adapter.GuestAdapter
import com.douglasborba.convidados.viewmodel.AllGuestsViewModel

class AllGuestFragment : Fragment() {

    private val mAdapter: GuestAdapter = GuestAdapter()

    private lateinit var allGuestsViewModel: AllGuestsViewModel

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        allGuestsViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_guest, container, false)

        // 1 - obter o recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        // 2 - definir um layout
        recycler.layoutManager = LinearLayoutManager(root.context)

        // 3 - definir um adapter
        recycler.adapter = mAdapter

        observer()

        allGuestsViewModel.load()

        return root
    }

    private fun observer(){
        allGuestsViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}
