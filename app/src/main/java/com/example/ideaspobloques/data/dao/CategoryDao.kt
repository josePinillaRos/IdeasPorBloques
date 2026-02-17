package com.example.ideaspobloques.data.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ideaspobloques.data.entities.CategoryEntity
@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories ORDER BY name ASC")
    fun getAll(): LiveData<List<CategoryEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: CategoryEntity): Long
    @Delete
    suspend fun delete(category: CategoryEntity)
}
