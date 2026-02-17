package com.example.ideaspobloques.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ideaspobloques.data.entities.CategoryEntity
import com.example.ideaspobloques.repository.AppRepository
import kotlinx.coroutines.launch
class CategoriesViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = AppRepository.getInstance(app)
    val categories = repo.getCategories()
    fun addCategory(name: String) = viewModelScope.launch { repo.addCategory(name) }
    fun deleteCategory(category: CategoryEntity) = viewModelScope.launch { repo.deleteCategory(category) }
}
