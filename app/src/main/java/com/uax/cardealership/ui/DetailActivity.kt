package com.uax.cardealership.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.cardealership.R
import com.uax.cardealership.databinding.ActivityDetailBinding
import com.uax.cardealership.models.Model

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var model: Model;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate( layoutInflater  )
        setContentView( binding.root )

        val bundle = intent.getBundleExtra("data")
        model = bundle!!.getSerializable( "car" )!! as Model
        binding.textDetails.text = "Brand: ${model.brand}\nModel: ${model.model}\nPrice: ${model.price}\nCv: ${model.cv}\nDescription: ${model.description}"
        binding.imgDetails.setImageResource( model.img )
    }
}