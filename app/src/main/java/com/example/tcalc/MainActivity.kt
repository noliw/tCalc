package com.example.tcalc


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoTv: TextView = findViewById(R.id.infoTv)
        val calcBtn: Button = findViewById(R.id.calcBtn)
        val billEt: EditText = findViewById(R.id.billET)
        val tipEt: EditText = findViewById(R.id.tipET)


        infoTv.visibility = View.INVISIBLE
        calcBtn.setOnClickListener {
            // bill
            val newBill = billEt.text.toString().toDouble()
            // tip percentage
            val newTip = tipEt.text.toString().toDouble() / 100
            // what the tip is going to be
            val tip = newBill * newTip
            // total
            val total = newBill + tip

            // make the info text visible
            infoTv.visibility = View.VISIBLE
            //set info text
            infoTv.text = "The tip is ${doubleToDollar(tip)} And the new total is ${doubleToDollar(total)}"

        }
    }

    fun doubleToDollar(number: Double): String {
       return "$" + String.format("%.2f,number")

    }
}