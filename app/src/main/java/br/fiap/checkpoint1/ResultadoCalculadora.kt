package br.fiap.checkpoint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class ResultadoCalculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_calculadora)

        val btnCalcular = findViewById<Button>(R.id.btnCalcula)


        btnCalcular.setOnClickListener { view: View ->
            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
            val valor1 = findViewById<EditText>(R.id.valor1).text.toString()
            val valor2 = findViewById<EditText>(R.id.valor2).text.toString()

            if (camposValidos(valor1, valor2)) {

                val val1 = valor1.toDouble()
                val val2 = valor2.toDouble()

                val soma = val1 + val2
                val subtracao = val1 - val2
                val multiplicacao = val1 * val2
                val divisao = val1 / val2

                val selecionado = when (radioGroup.checkedRadioButtonId) {
                    R.id.rdbSoma -> soma
                    R.id.rdbSubtracao -> subtracao
                    R.id.rdbMultiplicacao -> multiplicacao
                    R.id.rdbDivisao -> {
                        if (val1 != 0.0 && val2 != 0.0) divisao
                        else "Não existe divisão por 0"
                    }
                    else -> 0.0
                }
                var msg : String
                if (selecionado is Double) msg = "${String.format("%.2f", selecionado)}"
                else msg = "${selecionado}"
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun camposValidos(valor1: String, valor2: String): Boolean {
        if (valor1.trim().isEmpty() || valor2.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}