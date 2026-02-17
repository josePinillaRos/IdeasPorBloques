package com.example.ideaspobloques.repository
import android.content.Context
import com.example.ideaspobloques.data.db.AppDatabase
import com.example.ideaspobloques.data.entities.CategoryEntity
import com.example.ideaspobloques.data.entities.IdeaEntity
class AppRepository private constructor(context: Context) {
    private val db = AppDatabase.getInstance(context)
    private val categoryDao = db.categoryDao()
    private val ideaDao = db.ideaDao()
    // Categories
    fun getCategories() = categoryDao.getAll()
    suspend fun addCategory(name: String) = categoryDao.insert(CategoryEntity(name = name))
    suspend fun deleteCategory(category: CategoryEntity) = categoryDao.delete(category)
    // Ideas
    fun getIdeas(categoryId: Int) = ideaDao.getByCategory(categoryId)
    fun searchIdeas(categoryId: Int, query: String) = ideaDao.searchInCategory(categoryId, query)
    suspend fun addIdea(categoryId: Int, title: String, description: String?) =
        ideaDao.insert(IdeaEntity(categoryId = categoryId, title = title, description = description))
    suspend fun toggleDone(idea: IdeaEntity) = ideaDao.update(idea.copy(isDone = !idea.isDone))
    suspend fun deleteIdea(idea: IdeaEntity) = ideaDao.delete(idea)
    companion object {
        @Volatile private var INSTANCE: AppRepository? = null
        fun getInstance(context: Context): AppRepository =
            INSTANCE ?: synchronized(this) { INSTANCE ?: AppRepository(context).also { INSTANCE = it } }
    }
}
