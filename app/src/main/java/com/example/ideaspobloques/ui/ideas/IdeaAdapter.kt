package com.example.ideaspobloques.ui.ideas
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ideaspobloques.data.entities.IdeaEntity
import com.example.ideaspobloques.databinding.ItemIdeaBinding
class IdeaAdapter(
    private val onToggle: (IdeaEntity) -> Unit,
    private val onDelete: (IdeaEntity) -> Unit
) : ListAdapter<IdeaEntity, IdeaAdapter.VH>(DIFF) {
    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<IdeaEntity>() {
            override fun areItemsTheSame(o: IdeaEntity, n: IdeaEntity) = o.id == n.id
            override fun areContentsTheSame(o: IdeaEntity, n: IdeaEntity) = o == n
        }
    }
    inner class VH(val b: ItemIdeaBinding) : RecyclerView.ViewHolder(b.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemIdeaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.b.txtTitle.text = item.title
        holder.b.txtDescription.isVisible = !item.description.isNullOrBlank()
        holder.b.txtDescription.text = item.description
        holder.b.chkDone.isChecked = item.isDone
        holder.b.chkDone.setOnCheckedChangeListener { _, _ -> onToggle(item) }
        holder.b.btnDelete.setOnClickListener { onDelete(item) }
    }
}
