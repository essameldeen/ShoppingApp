package com.example.shoppingappmvvm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppingappmvvm.model.entities.ShoppingModel

@Database(
    entities = [ShoppingModel::class],
    version = 1
)
abstract class ShoppingDataBase : RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDataBase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createShoppingDataBase(context).also {
                instance = it
            }
        }

        private fun createShoppingDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDataBase::class.java,
                "shoppingDb.db"
            ).build()
    }


}