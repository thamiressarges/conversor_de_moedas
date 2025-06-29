package com.example.conversordemoedas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.example.conversordemoedas.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var dollarRate = 5.48
    private val usdFormat = NumberFormat.getCurrencyInstance(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        binding.edtAmountBrl.doAfterTextChanged { text ->
            val brl = text?.toString()
                ?.replace(',', '.')
                ?.toDoubleOrNull() ?: 0.0

            val usd = brl / dollarRate

            binding.txtAmountUsd.text = usdFormat.format(usd)
        }
    }
}