package util

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import com.google.zxing.qrcode.QRCodeWriter
import org.jetbrains.skia.Image
import org.jetbrains.skiko.toImage
import java.awt.image.BufferedImage

object QRCodeUtil {

    private val qrCodeWriter = QRCodeWriter()

    fun encode(text: String, width: Int, height: Int): ImageBitmap {
        val bitMatrix = qrCodeWriter.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, width, height)
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        for (x in 0 until width) {
            for (y in 0 until height) {
                image.setRGB(x, y, if (bitMatrix[x, y]) 0x00ff0000 else 0xffffffff.toInt())
            }
        }
        return image.toComposeImageBitmap()
    }
}