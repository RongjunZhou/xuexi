package config

import interceptor.retrofit.RequestInterceptor
import interceptor.retrofit.ResponseInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig{
    companion object{

        private val retrofit: Retrofit.Builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client (
                OkHttpClient.Builder()
                    .addInterceptor(RequestInterceptor())
                    .addInterceptor(ResponseInterceptor())
                    .build()
            )

        fun getRetrofit(url: String): Retrofit {
            return retrofit.baseUrl(url).build()
        }

        fun <T> getRetrofit(url: String, service: Class<T>): T {
            return retrofit.baseUrl(url).build().create(service)
        }
    }
}