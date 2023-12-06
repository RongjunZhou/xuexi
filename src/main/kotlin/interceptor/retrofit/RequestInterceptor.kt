package interceptor.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import store.CookieStore

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Cookie", CookieStore.getCookie())
        return chain.proceed(builder.build())
    }
}