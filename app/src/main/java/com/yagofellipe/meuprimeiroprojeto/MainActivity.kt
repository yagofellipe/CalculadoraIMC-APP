package com.yagofellipe.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtAltura: EditText = findViewById(R.id.inputAltura)
        val edtPeso: EditText = findViewById(R.id.inputPeso)
        val button: Button = findViewById(R.id.btn_clique)

        button.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()
            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                val altura: Float = edtAltura.text.toString().toFloat()
                val peso: Float = edtPeso.text.toString().toFloat()
                val expAltura: Float = altura * altura
                val result = peso / expAltura
                println(result)

                val intent = Intent(this,ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }else {
                Toast.makeText(this,"Preencha corretamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}