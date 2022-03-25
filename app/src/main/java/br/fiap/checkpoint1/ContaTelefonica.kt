package br.fiap.checkpoint1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContaTelefonica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)

        val btnCalcTel = findViewById<Button>(R.id.btnCalcTel)

        btnCalcTel.setOnClickListener { view: View ->
            val assinatura = findViewById<EditText>(R.id.txtAssinatura).text.toString()
            val minLocal = findViewById<EditText>(R.id.txtMinLocal).text.toString()
            val minCel = findViewById<EditText>(R.id.txtMinCel).text.toString()

            if (camposValidos(assinatura, minLocal, minCel)) {
                val chamadaLocal = 0.04 * minLocal.toDouble()
                val chamadaCel = 0.2 * minCel.toDouble()
                val total = assinatura.toDouble() + chamadaLocal + chamadaCel

                val msg = """Assinatura               :    R$ ${String.format("%.2f", assinatura.toDouble())}
                |Chamada Local      :    R$ ${String.format("%.2f", chamadaLocal)}
                |Chamada Celular   :    R$ ${String.format("%.2f", total)}
                |
                |Valor Total               :    R$ ${String.format("%.2f", total)}
            """.trimMargin("|")

                var intentResultAssinatura = Intent(this, ResultAssinaturaActivity::class.java)
                intentResultAssinatura.putExtra("msg", msg)
                startActivity(intentResultAssinatura)
            }

        }
    }

    fun camposValidos(assinatura: String, minLocal: String, minCel: String): Boolean {
        if (assinatura.trim().isEmpty() || minLocal.trim().isEmpty() || minCel.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}