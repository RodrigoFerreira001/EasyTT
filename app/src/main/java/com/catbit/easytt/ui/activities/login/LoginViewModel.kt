package com.catbit.easytt.ui.activities.login

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catbit.easytt.R
import com.catbit.easytt.commons.SingleLiveEvent
import com.catbit.easytt.exceptions.LoginErrorException
import com.catbit.easytt.repositories.SharedPreferencesRepository
import com.catbit.easytt.repositories.TimeTrackingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class LoginViewModel @ViewModelInject constructor(
    private val context: Context,
    private val preferencesRepository: SharedPreferencesRepository,
    private val timeTrackingRepository: TimeTrackingRepository
): ViewModel(){

    private val nameKey = "currentUser"
    private val currentUserKey = "name"
    private val passwordKey = "password"

    var errorMsg = ""

    private val _showProgressBar = MutableLiveData<Boolean>(false)
    val showProgressBar: LiveData<Boolean>
        get() = _showProgressBar

    private val _showSnackBar = SingleLiveEvent<Boolean>(false)
    val showSnackBar: LiveData<Boolean>
        get() = _showSnackBar

    private val _loginSuccessful = SingleLiveEvent<Boolean>(false)
    val loginSuccessful: LiveData<Boolean>
        get() = _loginSuccessful

    fun login(username: String, password: String) {

        _showProgressBar.postValue(true)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val name = timeTrackingRepository.login(username, password)
                preferencesRepository.save(nameKey, name)
                preferencesRepository.save(passwordKey, password)
                preferencesRepository.save(currentUserKey, username)
                _loginSuccessful.postValue(true)
            } catch (e: LoginErrorException) {
                errorMsg = context.getString(R.string.erro_ao_realizar_login)
                _showSnackBar.postValue(true)
            } catch (e: UnknownHostException) {
                errorMsg = context.getString(R.string.erro_conexao)
                _showSnackBar.postValue(true)
            } catch (e: SocketTimeoutException) {
                errorMsg = context.getString(R.string.erro_timeout)
                _showSnackBar.postValue(true)
            }

            _showProgressBar.postValue(false)
        }
    }
}