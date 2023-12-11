package com.example.shoplistik.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplistik.data.ShopListRepositoryImpl
import com.example.shoplistik.domain.DeleteShopItemUseCase
import com.example.shoplistik.domain.EditShopItemUseCase
import com.example.shoplistik.domain.GetShopItemUseCase
import com.example.shoplistik.domain.GetShopListUseCase
import com.example.shoplistik.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList =  getShopListUseCase.getShopList() // Создаем объект типа LiveData, потом на него будем ссылаться в Activity

    fun deleteShopItem (shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enable =! shopItem.enable)
        editShopItemUseCase.editShopItem(newItem)
    }
}