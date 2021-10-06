package com.misiontic2022.app.tsuri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SelectorFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector_fragment)
    }

    fun clickPoi(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun clickDetail(view: View){
        val intent = Intent(this, MainActivityInit::class.java)
        startActivity(intent)
    }
}