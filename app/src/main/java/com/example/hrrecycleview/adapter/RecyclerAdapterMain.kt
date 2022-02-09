package com.example.hrrecycleview.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.hrrecycleview.R
import com.example.hrrecycleview.data.DataListItem
import com.example.hrrecycleview.data.DataListSecondActivity

class RecyclerAdapterMain internal constructor(context: Context?, dataListItem: List<DataListItem>, private val onClickListener: OnRecClickListenerMain) :
    RecyclerView.Adapter<RecyclerAdapterMain.ViewHolder>() {


    private val inflater: LayoutInflater
    private val dataListItem: List<DataListItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: DataListItem = dataListItem[position]
        holder.nameView.setText(person.name)
        holder.textView.setText(person.text)
        holder.imgView.setImageResource(person.imageId)

        holder.itemView.setOnClickListener {

            onClickListener.onClick(person,position) }

    }

    override fun getItemCount(): Int {
        return dataListItem.size
    }

    class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView
        val textView: TextView
        val imgView: ImageView


        init {
            nameView = view.findViewById(R.id.name)
            textView = view.findViewById(R.id.text)
            imgView = view.findViewById(R.id.img)
        }
    }

    init {

        this.dataListItem = dataListItem
        inflater = LayoutInflater.from(context)
    }

}

