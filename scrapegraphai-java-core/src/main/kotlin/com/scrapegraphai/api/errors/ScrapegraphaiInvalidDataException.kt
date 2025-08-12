package com.scrapegraphai.api.errors

class ScrapegraphaiInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    ScrapegraphaiException(message, cause)
