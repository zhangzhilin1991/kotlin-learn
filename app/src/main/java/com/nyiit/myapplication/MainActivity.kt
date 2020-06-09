package com.nyiit.myapplication

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity";
    }

    private val imageUrl = "https://kaixue.io/content/images/2019/09/kotlin_coroutines_cover.jpg"

    private lateinit var view: View
    private lateinit var imageView : ImageView
    private lateinit var imageView_1_4 : ImageView
    private lateinit var imageView_1_9 : ImageView

    private lateinit var privateConstructor: PrivateConstructor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.hello);
        imageView = findViewById(R.id.hello_iv)
        imageView_1_4 = findViewById(R.id.hello_iv_1_4)
        imageView_1_9 = findViewById(R.id.hello_iv_1_9)
        printId(view);

        privateConstructor = PrivateConstructor.getInstance();
        //privateConstructor = PrivateConstructor();

        //list/array time cost
        listTest();

        //primary constrator
        var student:Student = Student("zhang", age = 21, cls = "三年二班");
        student.show();

        //list filter test
        listFunctionTest();

        //泛型测试
        genericTest(this);

        //协程测试
        corotinuesTest()
    }

    private fun printId(view : View?) : Unit {
        Log.d(TAG,  "view id = " + view?.id);
    }

    private fun corotinuesTest() {
        GlobalScope.launch(Dispatchers.Main){
            printThreadName()
            //val bitmap:Bitmap = getImage(imageUrl)
            val bitmap:Bitmap = getImageOnIoThread(imageUrl)
            imageView.setImageBitmap(bitmap)

            val bitmap1 = async { cropBitmap(bitmap, bitmap.width / 2, bitmap.height / 2, bitmap.width / 2, bitmap.height / 2) }
            val bitmap2 = async { cropBitmap(bitmap, bitmap.width / 3 * 2, bitmap.height / 3 * 2, bitmap.width / 3, bitmap.height / 3) }
            imageView_1_4.setImageBitmap(bitmap1.await())
            imageView_1_9.setImageBitmap(bitmap2.await())

        }
    }
}