package br.fiap.checkpoint1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIntegrantes = findViewById<Button>(R.id.btnIntegrantes)
        val btnCalcular = findViewById<Button>(R.id.btnCalculadora)
        val btnContaTel = findViewById<Button>(R.id.btnTel)

        btnIntegrantes.setOnClickListener { view: View? ->
            val msg = """Cristine Acocella
                |Jonathan Felix
                |Marcos Vinícius Ferreira
            """.trimMargin()
            exibirMensagem("Desenvolvido por", msg)
        }

        btnCalcular.setOnClickListener { view: View? ->

            var intentResultado = Intent(this, ResultadoCalculadora::class.java)
            startActivity(intentResultado)
        }

        btnContaTel.setOnClickListener { view: View? ->
            var intetTel = Intent(this, ContaTelefonica::class.java)
            startActivity(intetTel)
        }

    }

    fun exibirMensagem(titulo: String, mensagem: String) {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(titulo)
            .setMessage(mensagem)
            .setPositiveButton("OK", null)
        builder.create().show()
    }
}