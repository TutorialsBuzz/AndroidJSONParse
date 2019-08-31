package com.tutorialsbuzz.androidjsonparse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readSampleJSON()

        readArrayOfJsonObject()

    }


    private fun readSampleJSON(): Unit {
        val file_name = "sample.json"
        val bufferReader = application.assets.open(file_name).bufferedReader()
        val data = bufferReader.use {
            it.readText()
        }

        val jsonObject = JSONObject(data)

        val name = jsonObject.getString("name")
        val age = jsonObject.getInt("age")
        val height = jsonObject.getDouble("height")

        Log.d("readSampleJSON", "name : $name || age : $age || height: $height")

    }


    private fun readArrayOfJsonObject(): Unit {

        val bufferReader = application.assets.open("android_version.json").bufferedReader()
        val json_string = bufferReader.use {
            it.readText()
        }
        val jsonArray = JSONArray(json_string);

        for (i in 0..jsonArray.length() - 1) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(i)

            val name = jsonObject.getString("name")
            val version = jsonObject.getString("version")

            Log.d("readArrayOfJsonObject", "name: $name || version : $version  \n")

        }

    }
}
