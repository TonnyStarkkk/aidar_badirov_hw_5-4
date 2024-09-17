package com.example.aidar_badirov_hw_5_4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.aidar_badirov_hw_5_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.count.observe(this) { count ->
            binding.tvCount.text = count.toString()
        }

        viewModel.toastMessage.observe(this) { message ->
            message?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.textColor.observe(this) { color ->
            binding.tvCount.setTextColor(color)
        }
        binding.apply {
            btnIncrement.setOnClickListener {
                viewModel.increment()
            }
            btnDecrement.setOnClickListener {
                viewModel.decrement()
            }
        }
    }
}