package com.blockgemini.currency.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.blockgemini.currency.extensions.attachWith
import com.blockgemini.currency.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {


    lateinit var binding: FragmentDetailsBinding
    private val fragmentViewModel by viewModels<DetailsViewModel>()

    private val historyAdapter by lazy { HistoryAdapter() }
    private val otherAdapter by lazy { OtherAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.apply {

            viewModel = fragmentViewModel
            lifecycleOwner = viewLifecycleOwner
            listOf(rvHistorical).attachWith(listOf(historyAdapter))
            listOf(rvOther).attachWith(listOf(otherAdapter))

        }
        return binding.root
    }
}