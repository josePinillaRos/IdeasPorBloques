package com.example.ideaspobloques.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ideaspobloques.data.entities.IdeaEntity
import com.example.ideaspobloques.repository.AppRepository
import kotlinx.coroutines.launch
class IdeasViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = AppRepository.getInstance(app)
    val categoryId = MutableLiveData<Int>()
    val query = MutableLiveData("")
    private val ideasSource = MediatorLiveData<LiveData<List<IdeaEntity>>>()
    val ideas = MediatorLiveData<List<IdeaEntity>>()

    init {
        ideas.addSource(ideasSource) { source ->
            ideas.value = source.value ?: emptyList()
        }
        ideasSource.addSource(categoryId) { refreshIdeas() }
        ideasSource.addSource(query) { refreshIdeas() }
    }

    private fun refreshIdeas() {
        val id = categoryId.value ?: return
        val currentQuery = query.value.orEmpty()
        val newSource = if (currentQuery.isBlank()) repo.getIdeas(id) else repo.searchIdeas(id, currentQuery)
        val previousSource = ideasSource.value
        if (previousSource === newSource) return
        if (previousSource != null) {
            ideas.removeSource(previousSource)
        }
        ideasSource.value = newSource
        ideas.addSource(newSource) { list ->
            ideas.value = list ?: emptyList()
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
