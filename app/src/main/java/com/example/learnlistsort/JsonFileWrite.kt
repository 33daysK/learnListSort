package com.example.learnlistsort

import java.io.File
import org.json.JSONObject
import org.json.JSONArray
/**
 *  JsonFileWriteクラスです。
 *
 *  @auther:33daysK
 *  @version バージョン1.0 2020/03/18
 *  ファイルに書き込みをしています
 *  .use関数がJavaで言うtry-with-resorceの役割を果たしてくれているため自動的にcloseされます。
 */
fun jsonFileWrite(fileName: String, sortedList: List<Student>){
    // 書式を整えて画面に出力する関数
    printScreen(sortedList)

    // {datas:[sortedList]}という形のJSONObjectを作っています。
    val sorted_jsonOblect = JSONObject().put("datas",JSONArray(sortedList))

    // JSONデータは出力できているものの、読みやすい形にはなっていません。
    // また、順序もぐちゃぐちゃになってます。
    File(fileName).bufferedWriter().use { out ->
        out.write(sorted_jsonOblect.toString())
    }
}