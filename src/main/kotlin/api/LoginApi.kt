package api

import com.google.gson.JsonObject
import entity.QRCodeResp
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface LoginApi {
    @GET("/user/qrcode/generate")
    fun generateQRCode(): Call<QRCodeResp>

    @POST("/login/login_with_qr")
    fun checkLogin(@Body body: RequestBody): Call<JsonObject>
}