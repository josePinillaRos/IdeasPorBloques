package com.example.ideaspobloques.ui.categories
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ideaspobloques.data.entities.CategoryEntity
import com.example.ideaspobloques.databinding.ItemCategoryBinding
class CategoryAdapter(
    private val onOpen: (CategoryEntity) -> Unit,
    private val onDelete: (CategoryEntity) -> Unit
) : ListAdapter<CategoryEntity, CategoryAdapter.VH>(DIFF) {
    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<CategoryEntity>() {
            override fun areItemsTheSame(o: CategoryEntity, n: CategoryEntity) = o.id == n.id
            override fun areContentsTheSame(o: CategoryEntity, n: CategoryEntity) = o == n
        }
    }
    inner class VH(val b: ItemCategoryBinding) : RecyclerView.ViewHolder(b.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.b.txtName.text = item.name
        holder.b.root.setOnClickListener { onOpen(item) }
        holder.b.btnDelete.setOnClickListener { onDelete(item) }
    }
}
