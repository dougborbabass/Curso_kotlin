package com.douglasborba.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.douglasborba.convidados.viewmodel.GuestFormViewModel
import com.douglasborba.convidados.R
import com.douglasborba.convidados.service.constants.GuestConstants
import kotlinx.android.synthetic.main.activity_guest_form.*
import kotlinx.android.synthetic.main.row_guest.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel
    private var mGuestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()
        loadData()

        radio_present.isChecked = true
    }

    override fun onClick(v: View) {
        val id = v.id

        if (id == button_save.id) {
            val name = edit_name.text.toString()
            val presence = radio_present.isChecked

            mViewModel.save(mGuestId, name, presence)

        }
    }

    private fun observe() {
        mViewModel.saveGuest.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })

        mViewModel.guest.observe(this, Observer {
            edit_name.setText(it.name)

            if (it.presence) {
                radio_present.isChecked = true
            } else {
                radio_absent.isChecked = true
            }
        })
    }

    private fun loadData() {
        val bundle = intent.extras

        if (bundle != null) {
            mGuestId = bundle.getInt(GuestConstants.GUEST_ID)
            mViewModel.load(mGuestId)
        }
    }

    private fun setListeners() {
        button_save.setOnClickListener(this)
    }
}
