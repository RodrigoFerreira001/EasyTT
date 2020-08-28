package com.catbit.easytt

import com.catbit.easytt.datasource.fromcrawler.FormDataUtil
import org.junit.Assert.assertEquals
import org.junit.Test

class FormDataUtilTest {

    @Test
    fun getLoginFormDataTest() {
        val username = "username"
        val password = "password"
        val expected =
            "username=username&password=password&captcha=captcha&NTLMLogin=false&loginAuthenticOnserver=true&tsc=&sessionID=0&selectedEmployee=0&selectedCandidate=0&selectedVacancy=0&dtFmt=d%2Fm%2FY&tmFmt=H%3Ai%3As&shTmFmt=H%3Ai&dtTmFmt=d%2Fm%2FY%20H%3Ai%3As&language=0&idEmployeeLogged=0"

        val loginFormData = FormDataUtil.getLoginFormData(username, password)

        assertEquals(expected, loginFormData)
    }
}