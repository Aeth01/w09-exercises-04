package com.example.w09_exercises_03

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityMainAdapter(private val data : MutableList<NumStr>,
                          private val listener  : (NumStr) -> Unit) : RecyclerView.Adapter<ActivityMainAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row, parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, pos: Int) {
        val item = data[pos]
        holder.bind(item)
    }

    inner class Holder(private val v : View) : RecyclerView.ViewHolder(v) {
        private val num = v.findViewById<TextView>(R.id.tvNum)
        private val str = v.findViewById<TextView>(R.id.tvStr)

        fun bind(item : NumStr) {
            num.setText(item.num)
            str.setText(item.str)

            Log.e("INFO", "${item.num} | ${item.str}")
        }
    }

}