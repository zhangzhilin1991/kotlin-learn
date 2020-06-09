package com.nyiit.myapplication

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

fun collectionTest() {

}

fun setTest() {

}

fun mapTest() {

}

fun listTest() { //list/array test
    var maxCount = 1000_000

    var array : Array<Int> = Array<Int>(maxCount) { index -> index + 1}; //比最快慢一点
    var startTime = System.currentTimeMillis();
    array.average();
    var endTime = System.currentTimeMillis();
    println("Array time cost: " + (endTime - startTime));

    var intArray: IntArray = IntArray(maxCount) {index -> index + 1}; //最快
    startTime = System.currentTimeMillis();
    intArray.average();
    endTime = System.currentTimeMillis();
    println("intArray time cost: " + (endTime - startTime));

    var list: List<Int> = List(maxCount) {index -> index + 1}; //最慢
    startTime = System.currentTimeMillis();
    list.average();
    endTime = System.currentTimeMillis();
    println("list time cost: " + (endTime - startTime));
}

fun listFunctionTest() {
    var list = listOf(21, 40, 11, 33, 78)

    var result = list.filter { i ->
        println("listFunctionTest filter $i")  //先filter
        i % 3 == 0
    }.forEach{println("listFunctionTest find: $it")}
}

fun genericTest(context: Context) { //范形测试
   var arrayTv : Array<TextView> = arrayOf(TextView(context));
    var btn: Button = Button(context);
    btn.id = R.id.hello_btn
    //arrayBtn[0] = textView;
    fill(arrayTv, btn)

    var arrayBtn: Array<Button> = arrayOf(btn);
    copy(arrayTv, arrayBtn);

    //数组之间赋值不支持协变,子类array不能赋值给父亲类型的array
    //arrayTv = arrayBtn;
}

private fun <T> fill(array: Array<in T>, item: T) { //in类似 ? super, 下界是T
    array[0] = item
    println(array[0])
}

private fun <T> copy(arrayDst: Array<in T>, arraySrc: Array<out T>) { //out类似 ？ extends
    for (i in arraySrc.indices) {
        arrayDst[i] = arraySrc[i];
    }
    println(arrayDst[0])
}