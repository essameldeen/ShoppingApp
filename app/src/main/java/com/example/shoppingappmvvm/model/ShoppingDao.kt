package com.example.shoppingappmvvm.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppingappmvvm.model.entities.ShoppingModel

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingModel)

    @Delete
    suspend fun delete(item: ShoppingModel)

    @Query("SELECT * FROM shopping_table")
    fun getAllShoppingItems(): LiveData<List<ShoppingModel>>
}