package com.example.sharedprefs

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameText:EditText
    private lateinit var ageText:EditText
    private lateinit var sf:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.etName)
        ageText = findViewById(R.id.etAge)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()
    }

    override fun onPause() {
        super.onPause()
        val name = nameText.text.toString()
        val age = Integer.parseInt(ageText.text.toString())
        editor.putString("sf_name", name)
        editor.putInt("sf_age", age)
        editor.apply()
        editor.commit()
    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_age",0)
        nameText.setText(name)
        if(age != 0) {
            ageText.setText(age.toString())
        }

    }
}

