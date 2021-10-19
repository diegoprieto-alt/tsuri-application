package com.misiontic2022.app.tsuri

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import com.squareup.picasso.Picasso

class PoisAdapter (
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<PoisAdapter.ViewHolder>() {
    private var poiList = mutableListOf<Poi>()


    companion object {
        private lateinit var context: Context
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poi_list_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mPois = poiList[position]
        holder.nameLabel.text = mPois.name
        holder.descriptionLabel.text = mPois.description
        holder.punctuationLabel.text = mPois.punctuation
        //Picasso.get().load("https://wallpaperplay.com/walls/full/c/5/3/34778.jpg").into(holder.imagePlace)

        holder.imagePlace.setBackgroundResource(context.resources.getIdentifier(mPois.image,"drawable", context.packageName))

    }

    override fun getItemCount(): Int {
        return poiList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameLabel: TextView = itemView.findViewById(R.id.textview_name)
        var descriptionLabel: TextView = itemView.findViewById(R.id.textview_description)
        var punctuationLabel: TextView = itemView.findViewById(R.id.textview_punctuation)
        var imagePlace: ImageView = itemView.findViewById(R.id.imageview_poi)

    }

    fun updatePostList(pois: List<Poi>?) {
        this.poiList.clear()
        pois?.let { this.poiList.addAll(it) }
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}