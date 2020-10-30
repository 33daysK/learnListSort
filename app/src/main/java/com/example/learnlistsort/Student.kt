package com.example.learnlistsort

data class Student(
    val number: String = "",
    val name:   String = "",
    val kurasu: String = "",
    val age:    Int    = 0,
    val score:  Int    = 0)
{
    override fun toString(): String {
        return "$number,$name,$kurasu,$age,$score"
    }
}