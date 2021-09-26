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

        recycler = findViewById(R.id.poi_list)
        setupRecyclerView()
        generatePois()
    }

    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        mPois = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = PoisAdapter(mPois)
        recycler.adapter = mAdapter
    }

    /**
     * Generates mock contact data to populate the UI from a JSON file in the
     * assets directory, called from the options menu.
     */
    private fun generatePois() {
        val poisString = readPoiJsonFile()
        try {
            val poisJson = JSONArray(poisString)
            for (i in 0 until poisJson.length()) {
                val poiJson = poisJson.getJSONObject(i)
                val poi = Poi(
                    poiJson.getString("name"),
                    poiJson.getString("description"),
                    poiJson.getString("punctuation"),
                    poiJson.getString("image")
                )
                Log.d(TAG, "generatePois: $poi")
                mPois.add(poi)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    /**
     * Reads a file from the assets directory and returns it as a string.
     *
     * @return The resulting string.
     */
    private fun readPoiJsonFile(): String? {
        var poisString: String? = null
        try {
            val inputStream = assets.open("mock_pois.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            poisString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return poisString
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}