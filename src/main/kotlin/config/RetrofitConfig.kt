package config

import interceptor.RetrofitRequestInterceptor
import interceptor.RetrofitResponseInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    companion object{

        private val retrofit: Retrofit.Builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client (
                OkHttpClient.Builder()
                    .addInterceptor(RetrofitRequestInterceptor())
                    .addInterceptor(RetrofitResponseInterceptor())
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