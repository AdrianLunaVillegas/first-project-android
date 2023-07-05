package com.adriandevs.androidmaster1.firstapp

//VARIABLES

fun main(){

    //Int
    val age:Int = 30
    var age2:Int = 30

    //Long
    val example:Long = 30

    //Float
    val floatExample:Float = 30.5f

    //Double
    val doubleExample:Double =3241.3332123

//    println("Sumar: ")
//    println(age + age2)
//
//    println("Restar: ")
//    println(age - age2)
//
//    println("Multiplicar: ")
//    println(age * age2)
//
//    println("Dividir: ")
//    println(age / age2)
//
//    println("Modulo: ")
//    println(age % age2)

    /**
     * Variables Alfanuméricas
     */

    //Char
    val charExample1:Char ='e'
    val charExample2:Char ='2'
    val charExample3:Char ='@'

    //String
    val stringExample:String = "AdrianDevs suscribete"
    val stringExample2:String = "AdrianDevs"
    val stringExample3:String = "4"
    val stringExample4:String = "23"

    var stringConcatenada:String ="Hola"
    stringConcatenada = "Hola me llamo $stringExample2 y tengo $age años"
    print(stringConcatenada)

    val example123:String = age.toString()

    /**
     * Variables booleanas
     */

    //Boolean
    val booleanExample:Boolean = true
    val booleanExample2:Boolean = false
    val booleanExample3:Boolean = false


}