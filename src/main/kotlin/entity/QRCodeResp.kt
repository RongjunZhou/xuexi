package entity

import com.sun.jdi.connect.Connector.Argument

data class QRCodeResp(
    val success: Boolean,
    val errorCode: Int?,
    val errorMsg: String?,
    val result: String?,
    val argument: Any?
)
