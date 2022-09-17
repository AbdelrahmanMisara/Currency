package com.blockgemini.currency.extensions

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blockgemini.currency.ui.details.HistoryAdapter
import com.blockgemini.currency.ui.details.OtherAdapter
import com.blockgemini.domain.models.Currency
import com.blockgemini.domain.models.Rate

@BindingAdapter("list")
fun Spinner.setHistoryList(list: List<String>?) {
   adapter = ArrayAdapter<String?>(this.context,android.R.layout.simple_spinner_item,list?: listOf())
}

@BindingAdapter("history_list")
fun RecyclerView.setHistoryList(list: List<Rate>?) =
   (adapter as? HistoryAdapter)?.submitList(list)

@BindingAdapter("other_list")
fun RecyclerView.setOtherList(list: List<Currency>?) =
   (adapter as? OtherAdapter)?.submitList(list)


fun List<RecyclerView>.attachWith(adapters: List<RecyclerView.Adapter<*>>){
   forEachIndexed { index, _ ->
      this[index].adapter = adapters[index]
   }
}