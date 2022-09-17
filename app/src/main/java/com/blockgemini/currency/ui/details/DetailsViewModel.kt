package com.blockgemini.currency.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blockgemini.domain.models.Currency
import com.blockgemini.domain.models.Rate
import com.blockgemini.domain.usecase.HistoryUseCase
import com.blockgemini.domain.usecase.OthersCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val historyUseCase: HistoryUseCase,
    private val othersCurrencyUseCase: OthersCurrencyUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val historyList = MutableLiveData<List<Rate>?>()
    val otherList = MutableLiveData<List<Currency>?>()

    private val from: String? = savedStateHandle["from"]
    private val to: String? = savedStateHandle["to"]

    init {
        getHistory()
        getOthers()
    }
    private fun getHistory(){
        historyUseCase("$from,$to").onEach {
            historyList.value = it.rates

        }.launchIn(viewModelScope)
    }

    private fun getOthers(){
        othersCurrencyUseCase().onEach {
            otherList.value = it.currencies
        }.launchIn(viewModelScope)
    }
}