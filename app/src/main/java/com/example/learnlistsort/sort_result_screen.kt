package com.example.learnlistsort


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader


class sort_result_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort_result_screen)
        val intent: Intent = getIntent()
        var str =""

        val sortNumber = intent.getIntExtra("spinner1no",0)
        val sortOrder = intent.getIntExtra("spinner2no", 0)

        val assetManager = resources.assets
        val inputStream = assetManager.open("testjson.json") //Jsonファイル
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val jsonStringData: String = bufferedReader.readText() //データ
        // Stringを読み取ってJSONObjectの形にします。
        val datas_JsonObject = JSONObject(jsonStringData)

        // JSONObjectの中身をさらに読み取ってJsonArrayの形にします。
        val datas_JsonArray = datas_JsonObject.getJSONArray("datas")

        // Listを用意します。
        var mutableStudentList = mutableListOf<Student>()

        var count = 0
        while(count < datas_JsonArray.length()){

            // JsonArrayの中身を0番から順に取り出して、Student型のリストに格納しています。
            val student_JsonObject = datas_JsonArray.getJSONObject(count)
            val oneStudent = Student(
                student_JsonObject.getString("number"),
                student_JsonObject.getString("name"),
                student_JsonObject.getString("kurasu"),
                student_JsonObject.getInt("age"),
                student_JsonObject.getInt("score")
            )
            mutableStudentList.add(oneStudent)

            count++
        }
        // sortList関数はこの引き渡されたデータをもとに場合わけとソートを行います。
        str = sortList(sortNumber, sortOrder, mutableStudentList)

        val textView = findViewById(R.id.resultText) as TextView
        textView.text = str
    }

    fun onButtonTapped(view: View?){
        finish()
    }
}