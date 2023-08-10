package com.awakelab.oskar.ejercicion8apiperros.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RazaEntity::class, DetalleEntity::class], version = 1)
abstract class RazaDataBase(): RoomDatabase() {

    abstract fun getRazaDao(): RazaDao
    companion object {
        @Volatile
        private var INSTANCE: RazaDataBase? = null

        fun getDatabase(context: Context): RazaDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, RazaDataBase::class.java, "raza_ddbb"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}