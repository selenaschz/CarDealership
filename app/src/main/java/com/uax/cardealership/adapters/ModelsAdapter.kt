package com.uax.cardealership.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.uax.cardealership.R
import com.uax.cardealership.models.Model
import com.uax.cardealership.ui.DetailActivity

class ModelsAdapter(var modelsList: ArrayList<Model>, var ctx: Context ) : RecyclerView.Adapter<ModelsAdapter.MyHolder>() {
    class MyHolder(itemView: View) : ViewHolder(itemView) {
        val btn = itemView.findViewById<Button>( R.id.modelBtn )
        val text = itemView.findViewById<TextView>( R.id.modelText )
        val img = itemView.findViewById<ImageView>( R.id.modelImg )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        //View Pattern
        //View:
        val view = LayoutInflater.from( ctx ).inflate( R.layout.model_item, parent, false )
        //Hold and preserve the view
        val holder: MyHolder = MyHolder( view )

        return holder
    }

    override fun getItemCount(): Int {
        //How many rows
        return modelsList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //Behavior of each row
        val model = modelsList[ position ]
        holder.img.setImageResource( model.img )
        holder.text.text = model.model
        holder.btn.setOnClickListener {
            val intent = Intent( ctx, DetailActivity::class.java )
            val bundle = Bundle()
            bundle.putSerializable("car", model )
            intent.putExtra("data", bundle)
            ctx.startActivity( intent )
        }

        holder.img.setOnLongClickListener {
            modelsList.remove( model )
            notifyItemRemoved( position)
            true
        }
    }

    fun updateList( modelsList: ArrayList<Model> ) {
        this.modelsList = modelsList
        notifyDataSetChanged()
    }

}