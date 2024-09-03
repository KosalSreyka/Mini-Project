package com.example.miniproject.configuration

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

fun generateQrCode(text: String): Bitmap? {
    val writer = QRCodeWriter()
    val matrix = writer.encode(text, BarcodeFormat.QR_CODE, 300, 300)
    val width = matrix.width
    val height = matrix.height
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    for (x in 0 until width) {
        for (y in 0 until height) {
            bitmap.setPixel(x, y, if (matrix.get(x, y)) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
        }
    }
    return bitmap
}