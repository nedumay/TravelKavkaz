package com.example.hrrecycleview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.hrrecycleview.adapter.OnTravelClickListener
import com.example.hrrecycleview.adapter.TravelAdapter
import com.example.hrrecycleview.classave.Travel

/******************* Главная страница *******************/


class MainActivity : AppCompatActivity() {

    val travel: ArrayList<Travel> = ArrayList()
    var names: Array<String> = arrayOf("Архыз", "Пятигорск", "Домбай")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialDate()
        val resView: RecyclerView = findViewById(R.id.list)
        val travelClickListener = object: OnTravelClickListener {
            override fun onTravelClick(travel: Travel, position: Int) {
                when(position){
                    0 ->  {
                        val intent = Intent(this@MainActivity, Gornolyzhka::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(this@MainActivity, WalkCony::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@MainActivity, Dombay::class.java)
                        startActivity(intent)
                    }
                }

            }



        }
        val adapter = TravelAdapter(this, travel, travelClickListener)
        resView.adapter = adapter


    }

    private fun setInitialDate() {
        travel.add(
            Travel( "Всесезонный горнолыжный курорт «Архыз» — курорт в Зеленчукском районе " +
                "Карачаево-Черкесской Республики, сочетающий зимние и летние виды туризма. Расстояние до " +
                "Черкесска составляет 110 км, до ближайшего крупного аэропорта Минеральные Воды — 220 км.\n", R.drawable.gornolyzh)
        )
        travel.add(
            Travel( "Лучше отдыха на природе может быть только активный тур на природе. " +
                "Отдохните с пользой для души и здоровья. Самые популярные прогулки в " +
                "Пятигорске с ценами, отзывами и подробными программами на нашем сайте. " +
                "Выберите маршрут на этой странице и забронируйте онлайн.\n", R.drawable.cony)
        )
        travel.add(
            Travel("Горная местность Домбай – непревзойденная по красоте, числу природных и исторических памятников территория. " +
                "Для тех, кто хочет познакомиться с этим уникальным районом, мы предлагаем пешие и автомобильные экскурсии в сопровождении гидов.\n" +
                "Познакомьтесь с удивительными местами родной страны!\n", R.drawable.arhz)
        )



    }

    fun onClickInst(view: android.view.View) {
        val address: Uri = Uri.parse("https://www.instagram.com/kaukaz_tur/?hl=ru")
        val intent = Intent(Intent.ACTION_VIEW, address)
        startActivity(intent)
    }
    fun onClickVk(view: android.view.View) {
        val address: Uri = Uri.parse("https://vk.com/touristica_life")
        val intent = Intent(Intent.ACTION_VIEW, address)
        startActivity(intent)
    }
    fun onClickTg(view: android.view.View) {
        val address: Uri = Uri.parse("https://www.russiadiscovery.ru/regions/kavkaz/")
        val intent = Intent(Intent.ACTION_VIEW, address)
        startActivity(intent)
    }

}