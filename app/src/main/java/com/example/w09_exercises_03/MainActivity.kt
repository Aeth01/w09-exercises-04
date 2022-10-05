package com.example.w09_exercises_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter :ActivityMainAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var data : MutableList<NumStr>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lstView = findViewById<RecyclerView>(R.id.rvMain)
        linearLayoutManager = LinearLayoutManager(this)
        lstView.layoutManager = linearLayoutManager

        data = readDataFromFile(R.raw.test)

        adapter = ActivityMainAdapter(data) {
            showDetail(it)
        }
    }

    private fun readDataFromFile(id : Int) : MutableList<NumStr> {
        val dat = mutableListOf<NumStr>()

        resources.openRawResource(R.raw.test).bufferedReader().forEachLine {
            val splitVal = it.split(",")
            dat.add(NumStr(splitVal[0].toInt(), splitVal[1]))
        }

        return dat
    }

    private fun showDetail(item : NumStr) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("numstr", item)
    }
}