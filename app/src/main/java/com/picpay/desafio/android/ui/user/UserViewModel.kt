package com.picpay.desafio.android.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.usercase.GetUserUseCase
import com.picpay.desafio.android.util.ResultOf
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _state: MutableLiveData<UserViewState> = MutableLiveData()
    val state: LiveData<UserViewState> = _state

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            when (val list = getUserUseCase.invoke()) {
                is ResultOf.Success -> _state.postValue(UserViewState.UserSuccess(list.value))
                is ResultOf.Error -> _state.postValue(UserViewState.UserError(list.error))
            }
        }

    }
}