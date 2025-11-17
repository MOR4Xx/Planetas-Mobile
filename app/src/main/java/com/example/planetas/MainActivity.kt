package com.example.planetas

import PlanetaAdapter
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.emptyList

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private var planetas: List<Planeta>? = emptyList()
    private lateinit var adapter: PlanetaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Configura o RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

        // Obtenha a lista de planetas
        planetas = PlanetaData.getPlanetas()

        // Configura o Adapter e o click listener
        adapter = PlanetaAdapter(this, planetas, onClickPlaneta())
        recyclerView.adapter = adapter

//        listView = findViewById(R.id.listview)
//        val planetas = PlanetaData.getPlanetas()
//
//        listView.adapter = PlanetaAdapter(this, planetas)
//
//        listView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, idx: Int, id: Long) {
        val planeta = parent.getItemAtPosition(idx) as Planeta
        Toast.makeText(this, "Planeta: ${planeta.nome}", Toast.LENGTH_SHORT).show()
    }

    private fun onClickPlaneta(): PlanetaAdapter.PlanetaOnClickListener {
        return object : PlanetaAdapter.PlanetaOnClickListener {
            override fun onClickPlaneta(
                holder: PlanetaAdapter.PlanetasViewHolder?,
                idx: Int
            ) {
                val planeta = (planetas ?: emptyList())[idx]
                Toast.makeText(this@MainActivity, "Planeta: ${planeta.nome}", Toast.LENGTH_LONG)
                    .show()
            }

        }
    }
}