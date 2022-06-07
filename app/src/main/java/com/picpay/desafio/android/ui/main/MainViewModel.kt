package com.picpay.desafio.android.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.usercase.GetUserUseCase
import com.picpay.desafio.android.util.ResultOf
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _listUsers: MutableLiveData<List<User>> = MutableLiveData()
    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val users: LiveData<List<User>> = _listUsers
    val errorMessage: LiveData<String> = _errorMessage

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            when (val list = getUserUseCase.invoke()) {
                is ResultOf.Success -> _listUsers.postValue(list.value)
                is ResultOf.Error -> _errorMessage.postValue(list.message)
            }
        }

    }
}