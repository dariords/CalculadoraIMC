package com.dario.dev.imc

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

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textViewClassificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.0f)

        tvResult.text = result.toString()

        val classificacao = if(result < 18.5f){
            "Baixo peso  \uD83E\uDD72"
        }else if(result in 18.5f..24.9f){
            "Peso adequado \uD83E\uDD73"
        }else if(result in 25f..29.9f){
            "Sobrepeso \uD83D\uDE05"
        }else if(result in 30f..34.9f){
            "Obesidade grau 1 \uD83D\uDE27"
        }else if(result in 35f..39.9f){
            "Obesidade grau 2 \uD83D\uDE28"
        }else {
            "Obesidade extrema ☠\uFE0F"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}