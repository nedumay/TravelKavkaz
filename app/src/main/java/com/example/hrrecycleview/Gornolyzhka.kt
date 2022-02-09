package com.example.hrrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hrrecycleview.adapter.GornolyzhAdapter
import com.example.hrrecycleview.adapter.OnRecClickListener
import com.example.hrrecycleview.data.DataListSecondActivity


/***************** Активити страницы Архыз *****************/


class Gornolyzhka : AppCompatActivity() {

    val gornolyzhka: ArrayList<DataListSecondActivity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gornolyzhka)

        setInitialDate()
        val resView: RecyclerView = findViewById(R.id.listGorn)
        val GornolyzhClickListener = object : OnRecClickListener{
            override fun onTravelClick(gornolyzh: DataListSecondActivity, position: Int) {
                when(position){
                    0 -> Toast.makeText(applicationContext, "Общая информация/отдых в горах", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(applicationContext, "Инфраструктура Архыза", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(applicationContext, "Отели и жильё, где остановиться", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(applicationContext, "Покататься на лыжах/сноубордах/спуск на санках", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(applicationContext, "Прогулка под остопримечательностям Архыза, что посмотреть", Toast.LENGTH_SHORT).show()
                }
            }
        }
        val adapter = GornolyzhAdapter(this, gornolyzhka, GornolyzhClickListener)
        resView.adapter = adapter

    }

    private fun setInitialDate() {
        gornolyzhka.add(
            DataListSecondActivity( "Общая информация/отдых в горах", R.drawable.national_park)
        )
        gornolyzhka.add(
            DataListSecondActivity( "Инфраструктура Архыза", R.drawable.infrastruct)
        )
        gornolyzhka.add(
            DataListSecondActivity( "Отели и жильё, где остановиться", R.drawable.hotel)
        )
        gornolyzhka.add(
            DataListSecondActivity( "Покататься на лыжах/сноубордах/спуск на санках", R.drawable.skin_lyz)
        )
        gornolyzhka.add(
            DataListSecondActivity( "Прогулка по достопримечательностям Архыза, что посмотреть", R.drawable.walk)
        )

    }

    fun onClick(view: android.view.View) {
        val intentMap = Intent(this@Gornolyzhka, MapsActivityGornolyz::class.java)
        startActivity(intentMap)
    }
}