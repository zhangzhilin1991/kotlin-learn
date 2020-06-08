package com.nyiit.myapplication

class Student(var name:String, var age: Int, var cls: String) {

    init {
        println("Student: $name $age");
    }

    constructor(name: String): this(name, -1, "");

    constructor(name: String, age: Int):this(name, age, "");

    constructor(name: String, cls: String):this(name, -1, cls);

    fun show() {
        println("Student: {$name $age $cls}");
    }

}