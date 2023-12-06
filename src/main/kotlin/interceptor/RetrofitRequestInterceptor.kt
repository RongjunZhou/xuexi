package interceptor

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class RetrofitRequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Cookie", "")
        return chain.proceed(builder.build())
    }
}