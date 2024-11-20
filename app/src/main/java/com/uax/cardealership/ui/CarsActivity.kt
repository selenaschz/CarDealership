package com.uax.cardealership.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.uax.cardealership.R
import com.uax.cardealership.adapters.BrandsAdapter
import com.uax.cardealership.adapters.ModelsAdapter
import com.uax.cardealership.databinding.ActivityCarsBinding
import com.uax.cardealership.models.Brand
import com.uax.cardealership.models.Model

class CarsActivity : AppCompatActivity(), OnItemSelectedListener {
    private lateinit var binding: ActivityCarsBinding
    //--BRANDS--
    //Brands List
    private lateinit var brandsList: ArrayList<Brand>
    //Brands Adapter:
    private lateinit var brandsAdapter: BrandsAdapter

    //--MODELS--
    //Models list
    private lateinit var modelsList: ArrayList<Model>
    //Models Adapter
    private lateinit var modelsAdapter: ModelsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarsBinding.inflate( layoutInflater )
        setContentView( binding.root )
        instances()
        actions()

    }

    private fun instances() {
        brandsList = arrayListOf(
            Brand("Mercedes", R.drawable.mercedes ),
            Brand("BMW", R.drawable.bmw ),
            Brand("Ford", R.drawable.ford ),
            Brand("BYD", R.drawable.byd ),
            Brand("Audi", R.drawable.audi ),
            Brand("Peugeot", R.drawable.peugeot )
        )
        brandsAdapter = BrandsAdapter( brandsList, applicationContext )
        binding.brandSpinner.adapter = brandsAdapter

        modelsList = arrayListOf(
            Model(
                "C 63 S E PERFORMANCE",
                "Mercedes",
                140000,
                400,
                "Sports",
                R.drawable.c63
            ),
            Model(
                "E 63 S E PERFORMANCE",
                "Mercedes",
                240000,
                500,
                "Sports",
                R.drawable.e63
            ),
            Model(
                "RS 7 Sportback",
                "Audi",
                140000,
                400,
                "Sports",
                R.drawable.rs7
            ),
            Model(
                "RS Q 8 Sportback",
                "Audi",
                140000,
                400,
                "Sports",
                R.drawable.rsq8
            ),
            Model(
                "RS 5 Sportback",
                "Audi",
                140000,
                400,
                "Sports",
                R.drawable.rs5
            ),
            Model(
                "Mustang GT",
                "Ford",
                140000,
                400,
                "Sports",
                R.drawable.mustangt
            ),
            Model(
                "Mustang Mach",
                "Ford",
                140000,
                400,
                "Sports",
                R.drawable.mustangmach
            ),
            Model(
                "BYD Seal",
                "BYD",
                40000,
                200,
                "Sports",
                R.drawable.seal
            )
        )
        modelsAdapter = ModelsAdapter( modelsList, this )
        binding.recyclerModels.adapter = modelsAdapter
        //Screen orientation:
        if ( resources.configuration.orientation == 1 ) {
            //Display models in a vertical list (linear layout)
            binding.recyclerModels.layoutManager =
                LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false )
        } else {
            //Display models in a grid layout (2 columns per row)
            binding.recyclerModels.layoutManager =
                GridLayoutManager( this, 2 )
        }



    }

    private fun actions() {
        binding.brandSpinner.onItemSelectedListener = this
    }

    //Methods OnItemSelectedListener:
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val selectedBrand: Brand = brandsAdapter.getItem( p2 )
        val filteredList: ArrayList<Model> = modelsList.filter {
            it.brand.equals( selectedBrand.name, ignoreCase = true )
        } as ArrayList<Model>
        modelsAdapter.updateList( filteredList )
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}