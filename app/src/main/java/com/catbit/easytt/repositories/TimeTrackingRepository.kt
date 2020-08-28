package com.catbit.easytt.repositories

import com.catbit.easytt.interfaces.DataSourceBase

class TimeTrackingRepository(val dataSource: DataSourceBase) {
    fun login(username: String, password: String): String {
        return dataSource.login(username, password)
    }

    fun punchIn(userName: String, password: String): Boolean {
        return dataSource.punchIn(userName, password)
    }
}