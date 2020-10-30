package com.example.learnlistsort

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var spinner1Position: Int = 0
    var spinner2Position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner1: Spinner = findViewById(R.id.spinner1)
        val orderSpinner: Spinner = findViewById(R.id.spinner2)
        val array: Array<String> = resources.getStringArray(R.array.itemSelect)
        val orderArray: Array<String> = resources.getStringArray(R.array.sortOrder)

        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            array
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter
        // リスナーを登録
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinner1Position = position
                //textView.text = item
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        val orderAdapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            orderArray
        )
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        orderSpinner.adapter = orderAdapter

        // 二番目のリスナーを登録
        orderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                spinner2Position = position
                //textView.text = item
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

    }

    // 実行ボタンタップ時
    fun onButtonTapped(view: View?){
        val intent = Intent(this, sort_result_screen::class.java)
        intent.putExtra("spinner1no", spinner1Position)
        intent.putExtra("spinner2no", spinner2Position)
        startActivity(intent)
    }


}