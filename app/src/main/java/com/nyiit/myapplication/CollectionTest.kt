package com.nyiit.myapplication

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