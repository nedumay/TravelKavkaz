package com.example.hrrecycleview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hrrecycleview.adapter.OnRecClickListener
import com.example.hrrecycleview.adapter.OnRecClickListenerMain
import com.example.hrrecycleview.adapter.RecyclerAdapterMain
import com.example.hrrecycleview.data.DataListItem
import com.example.hrrecycleview.data.DataListSecondActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

/******************* Главная страница *******************/

class MainActivity : AppCompatActivity() {

    val dataListItem: ArrayList<DataListItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialDate()
        val resView: RecyclerView = findViewById(R.id.list)
        val onClickListener = object: OnRecClickListenerMain {
            override fun onClick(dataListItem: DataListItem, position: Int) {
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
        val adapter = RecyclerAdapterMain(this, dataListItem, onClickListener)
        resView.adapter = adapter
    }

    private fun setInitialDate() {
        dataListItem.add(
            DataListItem( "Архыз","Всесезонный горнолыжный курорт «Архыз» — курорт в Зеленчукском районе " +
                "Карачаево-Черкесской Республики, сочетающий зимние и летние виды туризма. Расстояние до " +
                "Черкесска составляет 110 км, до ближайшего крупного аэропорта Минеральные Воды — 220 км.\n", R.drawable.gornolyzh)
        )
        dataListItem.add(
            DataListItem( "Пятигорск","Лучше отдыха на природе может быть только активный тур на природе. " +
                "Отдохните с пользой для души и здоровья. Самые популярные прогулки в " +
                "Пятигорске с ценами, отзывами и подробными программами на нашем сайте. " +
                "Выберите маршрут на этой странице и забронируйте онлайн.\n", R.drawable.cony)
        )
        dataListItem.add(
            DataListItem("Домбай","Горная местность Домбай – непревзойденная по красоте, числу природных и исторических памятников территория. " +
                "Для тех, кто хочет познакомиться с этим уникальным районом, мы предлагаем пешие и автомобильные экскурсии в сопровождении гидов.\n" +
                "Познакомьтесь с удивительными местами родной страны!\n", R.drawable.arhz)
        )



    }

}