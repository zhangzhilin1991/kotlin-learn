package com.nyiit.myapplication

class PrivateConstructor private constructor(){

    //private constructor(); //这样也行

    companion object{
        fun getInstance(): PrivateConstructor {
            return PrivateConstructor()
        }
    }
}