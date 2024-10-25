package com.nazwa.sitinazwaamanda_6304221484

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nazwa.sitinazwaamanda_6304221484.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener { calculate("luas") }
        binding.subtractButton.setOnClickListener { calculate("volume") }

    }

    private fun calculate(operation: String) {
        val num1 = binding.number1.text.toString().toDoubleOrNull()
        val num2 = binding.number2.text.toString().toDoubleOrNull()
        val num3 = binding.number3.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null || num3 == null ) {
            binding.result.text = getString(R.string.result_invalid)
            return
        }

        val calculationResult = when (operation) {
            "luas" -> num1 * num2*num3
            "volume" -> (2*num1+num2)+(2*num1+num3)+(2*num2*num3)

            else -> null
        }

        binding.result.text = calculationResult?.toString() ?: getString(R.string.result_divide_zero)
    }
}
