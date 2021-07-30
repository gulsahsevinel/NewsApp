package com.gulsah.newsapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulsah.newsapp.R
import com.gulsah.newsapp.adapter.TopHeadlinesAdapter
import com.gulsah.newsapp.databinding.FragmentTopHeadlinesBinding
import com.gulsah.newsapp.repo.TopHeadlinesRepository
import com.gulsah.newsapp.viewModel.TopHeadlinesViewModel


class TopHeadlinesFragment : Fragment() {
    private lateinit var binding: FragmentTopHeadlinesBinding
    private lateinit var adapter: TopHeadlinesAdapter
    private lateinit var viewModel: TopHeadlinesViewModel

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


        binding.fragment = this
        binding.rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.allTopHeadlines.observe(viewLifecycleOwner) {
            adapter = TopHeadlinesAdapter(it)
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
    }


}