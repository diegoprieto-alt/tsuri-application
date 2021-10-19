package com.misiontic2022.app.tsuri

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.util.ArrayList
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private lateinit var mPois: ArrayList<Poi>
    private lateinit var mAdapter: PoisAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PoiFragment2.newInstance())
            .commitNow()
    }


    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}