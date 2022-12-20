package com.example.amphibians.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.amphibians.R
import com.example.amphibians.databinding.FragmentAmphibianDetailsBinding

class AmphibianDetailsFragment : Fragment() {
    val viewModel: AmphibianViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentAmphibianDetailsBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel
        return binding.root
    }


}