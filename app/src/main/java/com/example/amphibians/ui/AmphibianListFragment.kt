package com.example.amphibians.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.amphibians.R
import com.example.amphibians.databinding.FragmentAmphibianListBinding
import com.example.amphibians.ui.AmphibianViewModel

class AmphibianListFragment : Fragment() {
    private val viewModel: AmphibianViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAmphibianListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = AmphibianListAdapter(AmphibianListener { amphibian ->
            viewModel.onAmphibianClicked(amphibian)
            findNavController().navigate(R.id.action_amphibianListFragment_to_amphibianDetailsFragment2)
        })
        return binding.root
    }
}