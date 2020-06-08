package com.nyiit.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity";
    }

    private lateinit var view: View
    private lateinit var privateConstructor: PrivateConstructor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.hello);
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
    }

    private fun printId(view : View?) : Unit {
        Log.d(TAG,  "view id = " + view?.id);
    }
}