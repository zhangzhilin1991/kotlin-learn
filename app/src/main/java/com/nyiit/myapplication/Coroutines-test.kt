package com.nyiit.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

suspend fun printThreadName() = withContext(Dispatchers.IO){
    println("当前线程1： ${Thread.currentThread().name}");
}

suspend fun getImageOnIoThread(url: String): Bitmap = withContext(Dispatchers.IO){
    println("当前线程2： ${Thread.currentThread().name}");
    val urlImage = URL(url);
    val openConnection = urlImage.openConnection() as HttpURLConnection
    openConnection.requestMethod = "GET"
    openConnection.connect()
    val inputStream: InputStream = openConnection.inputStream
    BitmapFactory.decodeStream(inputStream)
}

fun getImage(url: String): Bitmap {
    val urlImage = URL(url);
    val openConnection = urlImage.openConnection() as HttpURLConnection
    openConnection.requestMethod = "GET"
    openConnection.connect()
    val inputStream: InputStream = openConnection.inputStream
    return BitmapFactory.decodeStream(inputStream)
}

fun cropBitmap(bitmap: Bitmap, x:Int, y: Int, width:Int, height:Int): Bitmap {
    return Bitmap.createBitmap(bitmap, x, y, width, height)
}