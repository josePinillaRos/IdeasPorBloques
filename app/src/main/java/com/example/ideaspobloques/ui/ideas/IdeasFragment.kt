package com.example.ideaspobloques.ui.ideas
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ideaspobloques.R
import com.example.ideaspobloques.data.entities.IdeaEntity
import com.example.ideaspobloques.databinding.FragmentIdeasBinding
import com.example.ideaspobloques.ui.common.ViewModelFactory
import com.example.ideaspobloques.viewmodel.IdeasViewModel
class IdeasFragment : Fragment() {
    private var _binding: FragmentIdeasBinding? = null
    private val binding get() = _binding!!
    private lateinit var vm: IdeasViewModel
    private lateinit var adapter: IdeaAdapter
    private val args: IdeasFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentIdeasBinding.inflate(inflater, container, false)
        vm = ViewModelProvider(this, ViewModelFactory(requireActivity().application))[IdeasViewModel::class.java]
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title = args.categoryName
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        vm.setCategory(args.categoryId)
        adapter = IdeaAdapter(
            onToggle = { vm.toggleDone(it) },
            onDelete = { confirmDelete(it) }
        )
        binding.recycler.adapter = adapter
        vm.ideas.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.emptyView.visibility = if (list.isNullOrEmpty()) View.VISIBLE else View.GONE
        }
        binding.fabAdd.setOnClickListener { showAddDialog() }
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                vm.query.value = s?.toString()?.trim() ?: ""
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
    private fun showAddDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_add_idea, null)
        val edtTitle = view.findViewById<EditText>(R.id.edtTitle)
        val edtDesc = view.findViewById<EditText>(R.id.edtDescription)
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.add)
            .setView(view)
            .setPositiveButton(R.string.save) { d, _ ->
                val title = edtTitle.text.toString().trim()
                val desc = edtDesc.text.toString().trim().ifBlank { null }
                if (title.isNotEmpty()) vm.addIdea(title, desc)
                d.dismiss()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }
    private fun confirmDelete(idea: IdeaEntity) {
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.delete) + " "" + idea.title + ""?")
            .setPositiveButton(R.string.delete) { _, _ -> vm.deleteIdea(idea) }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
