package com.example.ideaspobloques.data.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ideaspobloques.data.entities.IdeaEntity
@Dao
interface IdeaDao {
    @Query("SELECT * FROM ideas WHERE categoryId = :categoryId ORDER BY id DESC")
    fun getByCategory(categoryId: Int): LiveData<List<IdeaEntity>>
    @Query("SELECT * FROM ideas WHERE categoryId = :categoryId AND title LIKE '%' || :query || '%' ORDER BY id DESC")
    fun searchInCategory(categoryId: Int, query: String): LiveData<List<IdeaEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(idea: IdeaEntity): Long
    @Update
    suspend fun update(idea: IdeaEntity)
    @Delete
    suspend fun delete(idea: IdeaEntity)
}
