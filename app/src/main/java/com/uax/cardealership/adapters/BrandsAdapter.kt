package com.uax.cardealership.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.uax.cardealership.R
import com.uax.cardealership.models.Brand

class BrandsAdapter(var brandList: ArrayList<Brand>, var context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return brandList.size
    }

    override fun getItem(p0: Int): Brand {
        return brandList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //appearance of each row:
        //Get xml:
        val view: View = LayoutInflater.from( context ).inflate( R.layout.brand_item, p2, false )
        //Get image and text:
        val image = view.findViewById<ImageView>( R.id.spLogoImg )
        val text = view.findViewById<TextView>( R.id.spLogoText )

        //Get brand:
        val brand: Brand = brandList[p0]
        image.setImageResource( brand.logo )
        text.text = brand.name

        return view;
    }
}