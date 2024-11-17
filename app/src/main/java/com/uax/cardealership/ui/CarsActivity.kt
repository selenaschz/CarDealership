package com.uax.cardealership.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uax.cardealership.R
import com.uax.cardealership.databinding.ActivityCarsBinding
import com.uax.cardealership.models.Brand

class CarsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarsBinding
    //Brands List
    private lateinit var brandsList: ArrayList<Brand>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarsBinding.inflate( layoutInflater )
        setContentView( binding.root )


    }

}