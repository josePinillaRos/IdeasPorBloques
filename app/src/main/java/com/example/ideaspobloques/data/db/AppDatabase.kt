package com.example.ideaspobloques.data.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ideaspobloques.data.dao.CategoryDao
import com.example.ideaspobloques.data.dao.IdeaDao
import com.example.ideaspobloques.data.entities.CategoryEntity
import com.example.ideaspobloques.data.entities.IdeaEntity
@Database(entities = [CategoryEntity::class, IdeaEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun ideaDao(): IdeaDao
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ideas.db"
                ).build().also { INSTANCE = it }
            }
    }
}
