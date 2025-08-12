package com.scrapegraphai.api.errors

open class ScrapegraphaiException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
