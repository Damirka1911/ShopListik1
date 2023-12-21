package com.example.shoplistik.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplistik.R
import com.example.shoplistik.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    class ShopItemViewHolder(val view: View) :
        RecyclerView.ViewHolder(view) {   // этот класс как бы шаблон для по которму надо содовать Мшуц
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    var ShopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_shop_disabled,
                parent,
                false
            )
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(
        viewHolder: ShopItemViewHolder,
        position: Int,
    ) { // Заполняет существующие View
        val shopItem = ShopList[position]

        val staus = if (shopItem.enable){
            "Active"
        } else{
            "Not active"
        }
        viewHolder.tvName.text = "${shopItem.name} $staus"
        viewHolder.tvCount.text = shopItem.count.toString()
        viewHolder.view.setOnLongClickListener {
            true
        }
    }

    override fun getItemCount(): Int {
        return ShopList.size
    }
}