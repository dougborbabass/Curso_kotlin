package com.douglasborba.convidados.view

import android.content.Intent
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
import com.douglasborba.convidados.service.constants.GuestConstants
import com.douglasborba.convidados.view.adapter.GuestAdapter
import com.douglasborba.convidados.view.listener.GuestListener
import com.douglasborba.convidados.viewmodel.AllGuestsViewModel

class AllGuestFragment : Fragment() {

    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mViewModel: AllGuestsViewModel
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_guest, container, false)

        // 1 - obter o recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        // 2 - definir um layout
        recycler.layoutManager = LinearLayoutManager(root.context)

        // 3 - definir um adapter
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {

                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUEST_ID, id)

                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.load()
            }
        }

        mAdapter.attachListener(mListener)
        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }

    private fun observer() {
        mViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}
