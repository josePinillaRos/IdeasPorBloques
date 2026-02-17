package com.example.ideaspobloques.ui.common
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ideaspobloques.viewmodel.CategoriesViewModel
import com.example.ideaspobloques.viewmodel.IdeasViewModel
class ViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return when (modelClass) {
            CategoriesViewModel::class.java -> CategoriesViewModel(app) as T
            IdeasViewModel::class.java -> IdeasViewModel(app) as T
            else -> throw IllegalArgumentException("Unknown ViewModel ${modelClass.simpleName}")
        }
    }
}
