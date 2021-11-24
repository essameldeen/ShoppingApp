package com.example.shoppingappmvvm.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingModel(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}