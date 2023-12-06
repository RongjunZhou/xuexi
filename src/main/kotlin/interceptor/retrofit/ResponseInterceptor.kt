package interceptor.retrofit

import okhttp3.Cookie
import okhttp3.Interceptor
import okhttp3.Response
import store.CookieStore

class ResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies = originalResponse.headers("Set-Cookie")
            CookieStore.addCookie(cookies)
        }
        return originalResponse
    }
}