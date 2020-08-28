package com.catbit.easytt.datasource.fromcrawler

object Headers {
    private val accept = "Accept"
    private val acceptValue = "*/*"
    private val acceptEncoding = "Accept-Encoding"
    private val acceptEncodingValue = "gzip, deflate"
    private val acceptLanguage = "Accept-Language"
    private val acceptLanguageValue = "pt-BR,pt;q=0.9,en-GB;q=0.8,en-US;q=0.7,en;q=0.6"
    private val connection = "Connection"
    private val connectionValue = "keep-alive"
    private val contentLength = "Content-Length"
    private val contentType = "Content-Type"
    private val contentTypeValue = "application/x-www-form-urlencoded; charset=UTF-8"
    private val cookie = "Cookie"
    private val cookieValue = "ts=; clockDeviceToken2=nHuH/qaEaN1TzYclwDbze2UcjZeQtjjudvHqcjFufA=="
    private val host = "Host"
    private val hostValue = Urls.ttURL
    private val origin = "Origin"
    private val originValue = Urls.ttHome
    private val referer = "Referer"
    private val refererValue = "${Urls.ttHome}/"
    private val userAgent = "User-Agent"
    private val userAgentValue = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36"
    private val xRequestedWith = "X-Requested-With"
    private val xRequestedWithValue = "XMLHttpRequest"

    fun getLoginHeaders(contentLenghtValue: Int): Map<String, String> {
        return mapOf(
            accept to acceptValue,
            acceptEncoding to acceptEncodingValue,
            acceptLanguage to acceptLanguageValue,
            connection to connectionValue,
            contentLength to contentLenghtValue.toString(),
            contentType to contentTypeValue,
            cookie to cookieValue,
            host to hostValue,
            origin to originValue,
            referer to refererValue,
            userAgent to userAgentValue,
            xRequestedWith to xRequestedWithValue
        )
    }

    fun getPunchInHeaders(contentLenghtValue: Int): Map<String, String> {
        return mapOf(
            accept to acceptValue,
            acceptEncoding to acceptEncodingValue,
            acceptLanguage to acceptLanguageValue,
            connection to connectionValue,
            contentLength to contentLenghtValue.toString(),
            contentType to contentTypeValue,
            cookie to cookieValue,
            host to hostValue,
            origin to originValue,
            referer to refererValue,
            userAgent to userAgentValue,
            xRequestedWith to xRequestedWithValue
        )
    }
}