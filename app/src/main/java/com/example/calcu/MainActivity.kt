package com.example.calcu

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var num1: Float? = null
    private var num2: Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonSumar.setOnClickListener(this)
        botonRestar.setOnClickListener(this)
        botonMultiplicar.setOnClickListener(this)
        botonDividir.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (TextUtils.isEmpty(editNum1.text.toString())) {
            editNum1.error = "Ingresa un número"
            editNum1.requestFocus()
            return
        } else {
            num1 = editNum1.text.toString().toFloat()
        }

        if (TextUtils.isEmpty(editNum2.text.toString())) {
            editNum2.error = "Ingresa un número"
            editNum2.requestFocus()
            return
        } else {
            num2 = editNum2.text.toString().toFloat()
        }

        when (v?.id) {
            R.id.botonSumar -> {
                textResult.text = (num1!! + num2!!).toString()
            }
            R.id.botonRestar -> {
                textResult.text = (num1!! - num2!!).toString()
            }
            R.id.botonMultiplicar -> {
                textResult.text = (num1!! * num2!!).toString()
            }
            R.id.botonDividir -> {
                if (num2!! != 0f) {
                    textResult.text = (num1!! / num2!!).toString()
                } else {
                    textResult.text = "No se puede dividir entre cero"
                }
            }
        }
    }
}
