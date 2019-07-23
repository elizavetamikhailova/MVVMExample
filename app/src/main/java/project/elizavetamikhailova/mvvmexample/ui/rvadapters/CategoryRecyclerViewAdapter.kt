package project.elizavetamikhailova.mvvmexample.ui.rvadapters

import androidx.recyclerview.widget.RecyclerView


import android.view.LayoutInflater
import android.view.ViewGroup
import project.elizavetamikhailova.mvvmexample.databinding.ItemRepositoryBinding
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category


class CategoryRecyclerViewAdapter(var items: List<Category>,
                                  var listener: OnItemClickListener)
    : RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRepositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(list: List<Category>) {
        items = list
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category, listener: OnItemClickListener?) {
            binding.category = category
            if (listener != null) {
                binding.root.setOnClickListener { listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }

}