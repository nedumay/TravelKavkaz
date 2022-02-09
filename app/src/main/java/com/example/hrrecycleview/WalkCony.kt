package com.example.hrrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hrrecycleview.adapter.OnRecClickListener
import com.example.hrrecycleview.adapter.WalkConyAdapter
import com.example.hrrecycleview.data.DataListSecondActivity

/**********Акивити страницы курорта Пятигорск*************/


class WalkCony : AppCompatActivity() {

    val walkcony: ArrayList<DataListSecondActivity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_cony)

        setInitialDate()
        val resView: RecyclerView = findViewById(R.id.listPyat)
        val PyatigorskClickListener = object : OnRecClickListener {
            override fun onTravelClick(walkcony: DataListSecondActivity, position: Int) {
                when(position){
                    0 -> Toast.makeText(applicationContext, "Общая информация", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(applicationContext, "Инфраструктура Пятигорска", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(applicationContext, "Отели и жильё, где остановиться", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(applicationContext, "Музеи минеральных вод", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(applicationContext, "Прогулка по достопримечательностям Пятигорска, что посмотреть", Toast.LENGTH_SHORT).show()
                }
            }
        }
        val adapter = WalkConyAdapter(this, walkcony, PyatigorskClickListener)
        resView.adapter = adapter

    }

    private fun setInitialDate() {

        walkcony.add(DataListSecondActivity( "Общая информация", R.drawable.city))
        walkcony.add(DataListSecondActivity( "Инфраструктура Пятигорска", R.drawable.infrastruct))
        walkcony.add(DataListSecondActivity( "Отели и жильё, где остановиться", R.drawable.hotel))
        walkcony.add(DataListSecondActivity( "Музеи минеральных вод", R.drawable.museum))
        walkcony.add(DataListSecondActivity( "Прогулка по достопримечательностям Пятигорска, что посмотреть", R.drawable.walk))


    }

    fun onClick(view: android.view.View) {
        val intentMap = Intent(this@WalkCony, MapsActivityGornolyz::class.java)
        startActivity(intentMap)
    }
}