package com.example.shoplistik.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplistik.R

class ShopItemViewHolder (val view: View) :
    RecyclerView.ViewHolder(view) {   // этот класс как бы шаблон для по которму надо содовать Мшуц
    val tvName = view.findViewById<TextView>(R.id.tv_name)
    val tvCount = view.findViewById<TextView>(R.id.tv_count)
}