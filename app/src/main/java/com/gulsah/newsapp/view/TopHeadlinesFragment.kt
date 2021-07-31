package com.gulsah.newsapp.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.gulsah.newsapp.R
import com.gulsah.newsapp.adapter.TopHeadlinesAdapter
import com.gulsah.newsapp.databinding.FragmentTopHeadlinesBinding
import com.gulsah.newsapp.roomdb.ArticlesDao
import com.gulsah.newsapp.roomdb.ArticlesDatabase
import com.gulsah.newsapp.viewModel.TopHeadlinesViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable


class TopHeadlinesFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentTopHeadlinesBinding
    private lateinit var adapter: TopHeadlinesAdapter
    private lateinit var viewModel: TopHeadlinesViewModel
    private lateinit var db: ArticlesDatabase
    private lateinit var articlesDao: ArticlesDao
    val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_top_headlines, container, false)

        val bundle: TopHeadlinesFragmentArgs by navArgs()
        val id = bundle.sourceId
        viewModel.id.value = id

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.fragment = this
        binding.rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.allTopHeadlines.observe(viewLifecycleOwner) {
            adapter = TopHeadlinesAdapter(
                it,
                articlesDao,
                compositeDisposable,
                this.requireView(),
                viewModel
            )
            binding.adapter = adapter
        }
        viewModel.id.observe(viewLifecycleOwner) {
            viewModel.allTopHeadlines(it)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: TopHeadlinesViewModel by viewModels()
        viewModel = temp
        setHasOptionsMenu(true)

        //database
        db = Room.databaseBuilder(requireContext(), ArticlesDatabase::class.java, "ArticlesV3")
            .build()
        articlesDao = db.articlesDao()
    }

    //search
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_search, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchTopHeadlines(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //viewModel.searchTopHeadlines(newText)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }


}