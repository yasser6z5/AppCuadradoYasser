package com.example.appcuadradoyasser

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var redSquare: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redSquare = findViewById(R.id.redSquare)

        val btnArriba = findViewById<Button>(R.id.btnArriba)
        val btnAbajo = findViewById<Button>(R.id.btnAbajo)
        val btnIzquierda = findViewById<Button>(R.id.btnIzquierda)
        val btnDerecha = findViewById<Button>(R.id.btnDerecha)
        val btnAgrandar = findViewById<Button>(R.id.btnAgrandar)
        val btnReducir = findViewById<Button>(R.id.btnReducir)

        // Movimiento direccional mediante translación
        val step = 50f

        btnArriba.setOnClickListener {
            redSquare.translationY -= step
        }

        btnAbajo.setOnClickListener {
            redSquare.translationY += step
        }

        btnIzquierda.setOnClickListener {
            redSquare.translationX -= step
        }

        btnDerecha.setOnClickListener {
            redSquare.translationX += step
        }

        // Modificar tamaño (Agrandar y Reducir)
        btnAgrandar.setOnClickListener {
            adjustSquareSize(50)
        }

        btnReducir.setOnClickListener {
            adjustSquareSize(-50)
        }
    }

    private fun adjustSquareSize(amount: Int) {
        val layoutParams = redSquare.layoutParams
        val newSize = layoutParams.width + amount
        // Establecer un límite mínimo y máximo para que no desaparezca
        if (newSize in 50..600) {
            layoutParams.width = newSize
            layoutParams.height = newSize
            redSquare.layoutParams = layoutParams
        }
    }
}