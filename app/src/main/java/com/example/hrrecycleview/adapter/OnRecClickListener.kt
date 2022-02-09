package com.example.hrrecycleview.adapter

import com.example.hrrecycleview.data.DataListItem
import com.example.hrrecycleview.data.DataListSecondActivity

interface OnRecClickListener {
    fun onTravelClick(dataListSecondActivity: DataListSecondActivity, position: Int)
}

interface OnRecClickListenerMain{
    fun onClick(dataListItem: DataListItem, position: Int)
}
