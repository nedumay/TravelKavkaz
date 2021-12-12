package com.example.hrrecycleview.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.hrrecycleview.R
import com.example.hrrecycleview.classave.Travel

class TravelAdapter internal constructor(context: Context?, travel: List<Travel>, private val onClickListener: OnTravelClickListener) :
    RecyclerView.Adapter<TravelAdapter.ViewHolder>() {


    private val inflater: LayoutInflater
    private val travel: List<Travel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: Travel = travel[position]
        holder.flagView.setImageResource(person.imageId)
        holder.nameView.setText(person.name)

        holder.itemView.setOnClickListener {

            onClickListener.onTravelClick(person,position) }

    }

    override fun getItemCount(): Int {
        return travel.size
    }

    class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val flagView: ImageView
        val nameView: TextView

        init {
            flagView = view.findViewById(R.id.resFlag)
            nameView = view.findViewById(R.id.name)
        }
    }

    init {

        this.travel = travel
        inflater = LayoutInflater.from(context)
    }

}

