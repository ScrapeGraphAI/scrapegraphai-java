// File generated from our OpenAPI spec by Stainless.

package com.scrapegraphai.api.errors

import com.scrapegraphai.api.core.JsonValue
import com.scrapegraphai.api.core.http.Headers

abstract class ScrapegraphaiServiceException
protected constructor(message: String, cause: Throwable? = null) :
    ScrapegraphaiException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
