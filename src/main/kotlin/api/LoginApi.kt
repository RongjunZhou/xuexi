package api

import com.google.gson.JsonObject
import retrofit2.http.GET


interface LoginApi {
    @GET("/user/qrcode/generate")
    fun generateQRCode(): JsonObject
}