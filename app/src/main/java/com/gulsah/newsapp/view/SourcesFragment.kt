package com.gulsah.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulsah.newsapp.R
import com.gulsah.newsapp.adapter.SourcesAdapter
import com.gulsah.newsapp.databinding.FragmentSourcesBinding
import com.gulsah.newsapp.viewModel.SourcesViewModel

class SourcesFragment : Fragment() {
    private lateinit var binding: FragmentSourcesBinding
    private lateinit var adapter: SourcesAdapter
    private lateinit var viewModel: SourcesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sources, container, false)
        binding.fragment = this
        binding.rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.allSourcesList.observe(viewLifecycleOwner) {
            adapter = SourcesAdapter(it, viewModel)
            binding.adapter = adapter
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: SourcesViewModel by viewModels()
        viewModel = temp
    }
}