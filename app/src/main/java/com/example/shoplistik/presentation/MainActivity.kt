package com.example.shoplistik.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplistik.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerVew()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }
    private fun setupRecyclerVew(){
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopListAdapter()
        rvShopList.adapter = adapter
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLED, ShopListAdapter.MAX_POOL_SIZE)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DISABLED, ShopListAdapter.MAX_POOL_SIZE)
    }

}