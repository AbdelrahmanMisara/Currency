package com.blockgemini.currency.ui.convert_currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.blockgemini.currency.R
import com.blockgemini.currency.databinding.FragmentConvertCurrencyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConvertCurrencyFragment : Fragment() {

    lateinit var binding: FragmentConvertCurrencyBinding
    private val fragmentViewModel by viewModels<ConvertCurrencyViewModel>()

    private var isFromSelected = false
    private var isToSelected = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentConvertCurrencyBinding.inflate(inflater, container, false)
        binding.apply {

            viewModel = fragmentViewModel
            lifecycleOwner = viewLifecycleOwner


            if (isFromSelected) {
                spinnerFrom.onItemSelectedListener = setOnItemSelectedListenerFrom()
            } else{
                isFromSelected = true
            }
            spinnerTo.onItemSelectedListener = setOnItemSelectedListenerTo()
            ivSwap.setOnClickListener {
                swap()
            }

            etFrom.addTextChangedListener {
                convert()
            }
            btnDetails.setOnClickListener {
                findNavController().navigate(R.id.detailsFragment,
                    bundleOf("from" to spinnerFrom.selectedItem.toString(),
                        "to" to spinnerTo.selectedItem.toString()))
            }
        }


        return binding.root
    }

    private fun setOnItemSelectedListenerTo() =
        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
             if(isToSelected)   {
                convert()
            } else{
                isToSelected = true
            }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    private fun setOnItemSelectedListenerFrom() =
        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(isFromSelected)   {
                    convert()
                } else{
                    isFromSelected = true
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    private fun swap() {
        binding.apply {
            isFromSelected = false
            isToSelected = false
            val fromPosition = spinnerFrom.selectedItemPosition
            val toPosition = spinnerTo.selectedItemPosition
            spinnerFrom.setSelection(toPosition)
            spinnerTo.setSelection(fromPosition)
            convert()
        }
    }

    private fun convert() {
        binding.apply {
            fragmentViewModel.convert(etFrom.text.toString().toIntOrNull() ?: 0,
                spinnerFrom.selectedItem?.toString() ?: "",
                spinnerTo.selectedItem?.toString() ?: "")
        }
    }
}