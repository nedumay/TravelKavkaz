package com.example.hrrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hrrecycleview.adapter.GornolyzhAdapter
import com.example.hrrecycleview.adapter.OnTravelClickListener
import com.example.hrrecycleview.classave.Travel
import android.webkit.WebView






/***************** Активити страницы Архыз *****************/


class Gornolyzhka : AppCompatActivity() {

    val gornolyzhka: ArrayList<Travel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gornolyzhka)

        setInitialDate()
        val resView: RecyclerView = findViewById(R.id.listGorn)
        val GornolyzhClickListener = object : OnTravelClickListener{
            override fun onTravelClick(gornolyzh: Travel, position: Int) {
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
            Travel( "Общая информация/отдых в горах", R.drawable.national_park)
        )
        gornolyzhka.add(
            Travel( "Инфраструктура Архыза", R.drawable.infrastruct)
        )
        gornolyzhka.add(
            Travel( "Отели и жильё, где остановиться", R.drawable.hotel)
        )
        gornolyzhka.add(
            Travel( "Покататься на лыжах/сноубордах/спуск на санках", R.drawable.skin_lyz)
        )
        gornolyzhka.add(
            Travel( "Прогулка по достопримечательностям Архыза, что посмотреть", R.drawable.walk)
        )

    }

    fun onClick(view: android.view.View) {
        val intentMap = Intent(this@Gornolyzhka, MapsActivityGornolyz::class.java)
        startActivity(intentMap)
    }
}