package br.fiap.checkpoint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultAssinaturaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_assinatura)


        val txtResultAssinatura = findViewById<TextView>(R.id.txtResultAssinatura)

        txtResultAssinatura.text = intent.getStringExtra("msg")

    }
}