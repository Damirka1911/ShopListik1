package com.example.shoplistik.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplistik.R
import com.example.shoplistik.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var count  = 0
    class ShopItemViewHolder(val view: View) :
        RecyclerView.ViewHolder(view) {   // этот класс как бы шаблон для по которму надо содовать Мшуц
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
       Log.d("ShopListAdapter", "onCreateViewHolder, ${++count}" )
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
        val shopItem = shopList[position]

        val staus = if (shopItem.enable){
            "Active"
        } else{
            "Not active"
        }
        viewHolder.view.setOnLongClickListener {
            true
        }
        if (shopItem.enable){
            viewHolder.tvName.text = "${shopItem.name} $staus"
            viewHolder.tvCount.text = shopItem.count.toString()
            viewHolder.tvName.setTextColor(ContextCompat.getColor(viewHolder.view.context, android.R.color.holo_red_light))
        }
    }

    override fun onViewRecycled(viewHolder: ShopItemViewHolder) {
        super.onViewRecycled(viewHolder)
        viewHolder.tvName.text=""
        viewHolder.tvCount.text=""
        viewHolder.tvName.setTextColor(ContextCompat.getColor(viewHolder.view.context, android.R.color.white))
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return  if (item.enable){
            0
        } else {
            1
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }


    companion object{
        const val VIEW_TYPE_ENABLED =100
    }
}