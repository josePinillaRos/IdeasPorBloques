package com.example.ideaspobloques.ui.categories
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ideaspobloques.R
import com.example.ideaspobloques.data.entities.CategoryEntity
import com.example.ideaspobloques.databinding.FragmentCategoriesBinding
import com.example.ideaspobloques.ui.common.ViewModelFactory
import com.example.ideaspobloques.viewmodel.CategoriesViewModel
class CategoriesFragment : Fragment() {
    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!
    private lateinit var vm: CategoriesViewModel
    private lateinit var adapter: CategoryAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        vm = ViewModelProvider(this, ViewModelFactory(requireActivity().application))[CategoriesViewModel::class.java]
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CategoryAdapter(
            onOpen = { openCategory(it) },
            onDelete = { confirmDelete(it) }
        )
        binding.recycler.adapter = adapter
        vm.categories.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.emptyView.visibility = if (list.isNullOrEmpty()) View.VISIBLE else View.GONE
        }
        binding.fabAdd.setOnClickListener { showAddDialog() }
    }
    private fun showAddDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_add_category, null)
        val edt = view.findViewById<EditText>(R.id.edtName)
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.add)
            .setView(view)
            .setPositiveButton(R.string.save) { d, _ ->
                val name = edt.text.toString().trim()
                if (name.isNotEmpty()) vm.addCategory(name)
                d.dismiss()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }
    private fun confirmDelete(category: CategoryEntity) {
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.delete) + " "" + category.name + ""?")
            .setPositiveButton(R.string.delete) { _, _ -> vm.deleteCategory(category) }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }
    private fun openCategory(category: CategoryEntity) {
        val action = com.example.ideaspobloques.ui.categories.CategoriesFragmentDirections
            .actionCategoriesToIdeas(category.id, category.name)
        findNavController().navigate(action)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
