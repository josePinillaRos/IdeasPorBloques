package com.example.ideaspobloques.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.ideaspobloques.data.entities.IdeaEntity
import com.example.ideaspobloques.repository.AppRepository
import kotlinx.coroutines.launch
class IdeasViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = AppRepository.getInstance(app)
    val categoryId = MutableLiveData<Int>()
    val query = MutableLiveData("")
    val ideas = Transformations.switchMap(categoryId) { id ->
        Transformations.switchMap(query) { q ->
            if (q.isNullOrBlank()) repo.getIdeas(id) else repo.searchIdeas(id, q)
        }
    }
    fun setCategory(id: Int) { categoryId.value = id }
    fun addIdea(title: String, description: String?) = viewModelScope.launch {
        val id = categoryId.value ?: return@launch
        repo.addIdea(id, title, description)
    }
    fun toggleDone(idea: IdeaEntity) = viewModelScope.launch { repo.toggleDone(idea) }
    fun deleteIdea(idea: IdeaEntity) = viewModelScope.launch { repo.deleteIdea(idea) }
}
