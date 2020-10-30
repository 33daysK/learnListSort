package com.example.learnlistsort

import kotlin.system.exitProcess

/**
 *  DataCheckクラスです。
 *
 *  @auther:33daysK
 *  @version バージョン1.0 2020/03/18
 *  String型の数字をInt型に直すための関数です。
 *  複数個所で使用されていたので独立させました。
 */
fun stringToInt(stringLikeInt : String):Int{
    var return_Int : Int

    // toIntOrNullでIntにできるかどうかを判別しています。
    // IntにできなければexitProcess(0)で終了します。
    when(stringLikeInt.toIntOrNull()){
        is Int -> 	{
            return_Int = stringLikeInt.toInt()
            return return_Int
        }
        else -> {
            println("エラー: 不正な値です")
            exitProcess(0)
        }
    }
}