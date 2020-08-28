package com.catbit.easytt.datasource.fromcrawler

import java.net.URLEncoder
import java.nio.charset.Charset

object FormDataUtil {
    private val username = "username"
    private val userName = "userName"
    private val password = "password"
    private val captcha = "captcha"
    private val captchaValue = "captcha"
    private val nTLMLogin = "NTLMLogin"
    private val nTLMLoginValue = false
    private val loginAuthenticOnserver = "loginAuthenticOnserver"
    private val loginAuthenticOnserverValue = true
    private val tsc = "tsc"
    private val tscValue = ""
    private val sessionID = "sessionID"
    private val sessionIDValue = 0
    private val selectedEmployee = "selectedEmployee"
    private val selectedEmployeevalue = 0
    private val selectedCandidate = "selectedCandidate"
    private val selectedCandidateValue = 0
    private val selectedVacancy = "selectedVacancy"
    private val selectedVacancyValue = 0
    private val dtFmt = "dtFmt"
    private val dtFmtValue = "d/m/Y"
    private val tmFmt = "tmFmt"
    private val tmFmtValue = "H:i:s"
    private val shTmFmt = "shTmFmt"
    private val shTmFmtValue = "H:i"
    private val dtTmFmt = "dtTmFmt"
    private val dtTmFmtValue = "d/m/Y H:i:s"
    private val language = "language"
    private val languageValue = 0.toString()
    private val idEmployeeLogged = "idEmployeeLogged"
    private val idEmployeeLValue = 0.toString()
    private val deviceID = "deviceID"
    private val deviceIDValue = 2
    private val eventType = "eventType"
    private val eventTypeValue = 1
    private val cracha = "cracha"
    private val crachaValue = ""
    private val costCenter = "costCenter"
    private val costCenterValue = ""
    private val leave = "leave"
    private val leaveValue = ""
    private val func = "func"
    private val funcValue = ""

    fun getLoginFormData(username: String, password: String): String {
        val charset = Charset.forName("UTF-8").toString()

        return listOf(
            "${this.username}=$username",
            "${this.password}=$password",
            "$captcha=$captchaValue",
            "$nTLMLogin=$nTLMLoginValue",
            "$loginAuthenticOnserver=$loginAuthenticOnserverValue",
            "$tsc=$tscValue",
            "$sessionID=$sessionIDValue",
            "$selectedEmployee=$selectedEmployeevalue",
            "$selectedCandidate=$selectedCandidateValue",
            "$selectedVacancy=$selectedVacancyValue",
            "$dtFmt=${URLEncoder.encode(dtFmtValue, charset)}",
            "$tmFmt=${URLEncoder.encode(tmFmtValue, charset)}",
            "$shTmFmt=${URLEncoder.encode(shTmFmtValue, charset)}",
            "$dtTmFmt=${URLEncoder.encode(dtTmFmtValue, charset).replace("+", "%20")}",
            "$language=$languageValue",
            "$idEmployeeLogged=$idEmployeeLValue")
            .joinToString(separator = "&")
    }

    fun getPunchInFormData(userName: String, password: String): String {
        val charset = Charset.forName("UTF-8").toString()

        return listOf(
            "$deviceID=$deviceIDValue",
            "$eventType=$eventTypeValue",
            "${this.userName}=$userName",
            "${this.password}=$password",
            "$cracha=$crachaValue",
            "$costCenter=$costCenterValue",
            "$leave=$leaveValue",
            "$func=$funcValue",
            "$captcha=$captchaValue",
            "$tsc=$tscValue",
            "$sessionID=$sessionIDValue",
            "$selectedEmployee=$selectedEmployeevalue",
            "$selectedCandidate=$selectedCandidateValue",
            "$selectedVacancy=$selectedVacancyValue",
            "$dtFmt=${URLEncoder.encode(dtFmtValue, charset)}",
            "$tmFmt=${URLEncoder.encode(tmFmtValue, charset)}",
            "$shTmFmt=${URLEncoder.encode(shTmFmtValue, charset)}",
            "$dtTmFmt=${URLEncoder.encode(dtTmFmtValue, charset).replace("+", "%20")}",
            "$language=$languageValue",
            "$idEmployeeLogged=$idEmployeeLValue")
            .joinToString(separator = "&")
    }
}