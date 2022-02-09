package com.example.hrrecycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hrrecycleview.R
import com.example.hrrecycleview.data.DataListSecondActivity

class DombayAdapter internal constructor(context: Context, dombay: List<DataListSecondActivity>, private val onClickListener: OnRecClickListener):
    RecyclerView.Adapter<DombayAdapter.ViewHolder>() {

    class ViewHolder internal constructor(view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.image)
        val nameView: TextView = view.findViewById(R.id.name)

    }

    private val inflaterDombay: LayoutInflater
    private val dombay: List<DataListSecondActivity>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflaterDombay.inflate(R.layout.list_item_gornolyz, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos: DataListSecondActivity = dombay[position]
        holder.imageView.setImageResource(pos.imageId)
        holder.nameView.setText(pos.name)

        holder.imageView.setOnClickListener {
            onClickListener.onTravelClick(pos,position)
        }
    }

    override fun getItemCount(): Int {
        return dombay.size
    }

    init {
        this.dombay = dombay
        inflaterDombay = LayoutInflater.from(context)
    }

}