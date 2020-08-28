package com.catbit.easytt.interfaces

interface DataSourceBase {
    fun login(user: String, password: String): String
    fun punchIn(userName: String, password: String): Boolean
}