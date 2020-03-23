package com.douglasborba.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {

        if (validationOk()) {
            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy

            textTotalValeu.text = "R$ ${"%.2f".format(totalValue)}"
        }
    }

    private fun validationOk(): Boolean = (editDistance.text.toString() != ""
            && editAutonomy.text.toString() != ""
            && editPrice.text.toString() != "")
    
}
