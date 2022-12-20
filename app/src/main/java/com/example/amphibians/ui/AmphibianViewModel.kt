package com.example.amphibians.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch

class AmphibianViewModel : ViewModel() {
    private val _status = MutableLiveData<AmphibianApiStatus>()
    private val _amphibianList = MutableLiveData<List<Amphibian>>()
    private val _amphibian = MutableLiveData<Amphibian>()

    val status: LiveData<AmphibianApiStatus> = _status
    val amphibianList: LiveData<List<Amphibian>> = _amphibianList
    val amphibian: LiveData<Amphibian> = _amphibian

    init {
        getAmphibianList()
    }

    private fun getAmphibianList() {
        viewModelScope.launch {
            _status.value = AmphibianApiStatus.LOADING
            try {
                _amphibianList.value = AmphibianApi.retrofitService.getAmphibianList()
                _status.value = AmphibianApiStatus.DONE
            } catch (e: Exception) {
                _status.value = AmphibianApiStatus.ERROR
                _amphibianList.value = listOf()
            }
        }
    }

    fun onAmphibianClicked(amphibian: Amphibian) {
        _amphibian.value = amphibian
    }
}

enum class AmphibianApiStatus { LOADING, DONE, ERROR }