package com.blockgemini.currency.ui.convert_currency

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blockgemini.domain.usecase.ConvertUseCase
import com.blockgemini.domain.usecase.LatestCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ConvertCurrencyViewModel @Inject constructor(
    private val latestCurrencyUseCase: LatestCurrencyUseCase,
    private val convertUseCase: ConvertUseCase,
) : ViewModel() {

init {
    getLatest()
}

    val list = MutableLiveData<List<String>?>()
    val basePosition = MutableLiveData<Int>()
    val convertResult = MutableLiveData<String>()

    private fun getLatest(){
        latestCurrencyUseCase().onEach {
            val keys = it.rates?.keys?.toList()
            list.value = keys
            convert(1,it.base?:"",it.rates?.keys?.toList()?.get(0)?:"")
            keys?.map { key ->
                if(key == it.base){
                    basePosition.value = keys.indexOf(key)
                    return@map
                }
            }

        }.launchIn(viewModelScope)
    }

    fun convert(amount: Int, from: String, to: String) {
        if(from != "" && to != "")
        convertUseCase(amount, from, to).onEach {
                   convertResult.value = it.result.toString()
        }.launchIn(viewModelScope)

    }
}