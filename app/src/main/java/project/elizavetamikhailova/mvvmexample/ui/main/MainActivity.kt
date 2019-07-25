package project.elizavetamikhailova.mvvmexample.ui.main

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import project.elizavetamikhailova.mvvmexample.*
import project.elizavetamikhailova.mvvmexample.databinding.ActivityMainBinding
import project.elizavetamikhailova.mvvmexample.ui.rvadapters.CategoryRecyclerViewAdapter
import project.elizavetamikhailova.mvvmexample.ui.uimodels.Category
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(),
    CategoryRecyclerViewAdapter.OnItemClickListener {

    lateinit var binding: ActivityMainBinding
    private val categoryRecyclerViewAdapter =
        CategoryRecyclerViewAdapter(arrayListOf(), this)

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = categoryRecyclerViewAdapter
        viewModel.categories.observe(this,
            Observer<List<Category>> { it?.let{ categoryRecyclerViewAdapter.replaceData(it)} })

    }

    override fun onItemClick(position: Int) {

    }
}