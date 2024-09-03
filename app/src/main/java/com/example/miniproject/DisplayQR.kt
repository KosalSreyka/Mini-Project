package com.example.miniproject

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import com.example.miniproject.configuration.generateQrCode

@Composable
fun QrCodeDisplay(text: String,modifier: Modifier = Modifier) {
    val qrCodeBitmap: Bitmap? = generateQrCode(text) ?: return

    if (qrCodeBitmap != null) {
        Image(
            bitmap = qrCodeBitmap.asImageBitmap(),
            contentDescription = "QR Code",
            modifier = modifier
        )
    }
}