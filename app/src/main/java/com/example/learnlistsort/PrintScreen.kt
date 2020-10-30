package com.example.learnlistsort

/**
 *  PrintScreenクラスです。
 *
 *  @auther:33daysK
 *  @version バージョン1.0 2020/03/18
 *  スクリーンに表示するときの整形用の関数です。
 *  ${}内で計算しているのは日本語用の補正です。
 *  半角も全角も１文字としてカウントされるため、全角の日本語が混ざると表記が崩れます。
 *  なので日本語の長さの文だけ全体の長さを短くしておくことで補正しています。
 */
fun printScreen(sorted_studentList: List<Student>): String {
    var returntext = ""
    returntext += ("%3s%8s%21s%4s%3s".format("番号","名前","クラス","年齢","点数"))
    sorted_studentList.forEach{
        returntext += "\n"
        returntext += ("%-8s%-${25-it.name.length}s%5s%6d%5d".format(it.number,it.name,it.kurasu,it.age,it.score))
    }

    return returntext
}