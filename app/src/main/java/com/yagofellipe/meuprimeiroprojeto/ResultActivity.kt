package com.yagofellipe.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val textResult = findViewById<TextView>(R.id.textview_result)
        val textClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        textResult.text = result.toString()

        val classificacao = if (result < 18.5f){
            "ABAIXO DO PESO"
        }else if (result in 18.5f..24.9F){
            "NORMAL"
        }else if (result in 25f..29.9F){
            "SOBREPESO"
        }else if (result in 30f..39.9F){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }

        textClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}