package com.example.hrrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hrrecycleview.adapter.DombayAdapter
import com.example.hrrecycleview.adapter.OnTravelClickListener
import com.example.hrrecycleview.classave.Travel

class Dombay : AppCompatActivity() {

    val dombay: ArrayList<Travel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dombay)

        setInitialDate()
        val resView: RecyclerView = findViewById(R.id.listDomb)
        val DombayClickListener = object : OnTravelClickListener {
            override fun onTravelClick( dombay: Travel, position: Int) {
                when(position){
                    0 -> Toast.makeText(applicationContext, "Общая информация/отдых в горах", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(applicationContext, "Инфраструктура  Домбай", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(applicationContext, "Отели и жильё, где остановиться", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(applicationContext, "Покататься на лыжах/сноубордах/спуск на санках", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(applicationContext, "Прогулка под остопримечательностям Домбай, что посмотреть", Toast.LENGTH_SHORT).show()
                }
            }
        }
        val adapter = DombayAdapter(this,  dombay, DombayClickListener)
        resView.adapter = adapter

    }

    private fun setInitialDate() {
        dombay.add(Travel( "Общая информация/отдых в горах", R.drawable.national_park))
        dombay.add(Travel( "Инфраструктура Домбай", R.drawable.infrastruct))
        dombay.add(Travel( "Отели и жильё, где остановиться", R.drawable.hotel))
        dombay.add(Travel( "Покататься на лыжах/сноубордах/спуск на санках", R.drawable.skin_lyz))
        dombay.add(Travel( "Прогулка по достопримечательностям Домбай, что посмотреть", R.drawable.walk))

    }

    fun onClick(view: android.view.View) {
        val intentMap = Intent(this@Dombay, MapsActivityGornolyz::class.java)
        startActivity(intentMap)
    }
}