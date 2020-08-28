package com.catbit.easytt.datasource.fromcrawler

import com.catbit.easytt.exceptions.LoginErrorException
import com.catbit.easytt.exceptions.PunchInErrorException
import com.catbit.easytt.interfaces.DataSourceBase
import org.json.JSONObject
import org.jsoup.Connection
import org.jsoup.Jsoup

class CrawlerSource : DataSourceBase {
    private val cookies = mutableMapOf<String, String>()
    private var timeout = 5000
    var isLoggeg = false
    val selectedEmployeeNameKey = "selectedEmployeeName"
    val successKey = "success"
    val errorKey = "error"
    val typeKey = "type"
    val typeError = 2
    val msgKey = "msg"

    override fun login(username: String, password: String): String {
        val loginFormData = FormDataUtil.getLoginFormData(username, password)
        val loginHeaders = Headers.getLoginHeaders(loginFormData.length)

        val response = Jsoup.connect(Urls.ttLogin)
            .method(Connection.Method.POST)
            .requestBody(loginFormData)
            .headers(loginHeaders)
            .cookies(cookies)
            .timeout(timeout)
            .execute()

        val result = JSONObject(response.parse().text())

        if (!result.getBoolean(successKey)) {
            isLoggeg = false
            throw LoginErrorException(result.getString(errorKey))
        } else {
            isLoggeg = true
        }

        val name = result.getString(selectedEmployeeNameKey)

        return name
    }

    override fun punchIn(userName: String, password: String): Boolean {
        val punchInFormData = FormDataUtil.getPunchInFormData(userName, password)
        val punchInHeaders = Headers.getPunchInHeaders(punchInFormData.length)

        val response = Jsoup.connect(Urls.ttLogin)
            .method(Connection.Method.POST)
            .requestBody(punchInFormData)
            .headers(punchInHeaders)
            .cookies(cookies)
            .timeout(timeout)
            .execute()

        val result = JSONObject(response.parse().text())

        if (result.getInt(typeKey) == typeError) {
            isLoggeg = false
            throw PunchInErrorException(result.getString(msgKey))
        } else {
            isLoggeg = true
        }

        return true
    }
}