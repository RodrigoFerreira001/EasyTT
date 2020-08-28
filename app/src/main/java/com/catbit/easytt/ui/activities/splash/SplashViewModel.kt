package com.catbit.easytt.ui.activities.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.catbit.easytt.repositories.SharedPreferencesRepository

class SplashViewModel @ViewModelInject constructor(
    val preferencesRepository: SharedPreferencesRepository
) : ViewModel() {

    private val currentUserKey = "currentUser"

    fun isLogged():Boolean {
        return preferencesRepository.containsKey(currentUserKey)
    }
}