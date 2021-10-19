package com.misiontic2022.app.tsuri

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper

import com.misiontic2022.app.tsuri.placeholder.PlaceholderContent.PlaceholderItem


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class PoiFragment2 : Fragment(), PoisAdapter.OnItemClickListener
 {
     companion object {
         fun newInstance() = PoiFragment2()
     }

     private lateinit var viewModel: PoiViewModel
     private lateinit var postAdapter: PoisAdapter

     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View {
         val view = inflater.inflate(R.layout.fragment_item_list, container, false)
         val postList = view.findViewById<RecyclerView>(R.id.post_list)

         setupRecyclerView(postList)
         return view
     }

     override fun onActivityCreated(savedInstanceState: Bundle?) {
         super.onActivityCreated(savedInstanceState)
         viewModel = ViewModelProvider(this).get(PoiViewModel::class.java)

         viewModel.poisLiveData.observe(viewLifecycleOwner, Observer {
             postAdapter.updatePostList(it)
         })
     }


     private fun setupRecyclerView(recyclerView: RecyclerView) {
         postAdapter = PoisAdapter(this as PoisAdapter.OnItemClickListener)
         recyclerView.adapter = postAdapter

     }

     override fun onItemClick(position: Int) {
         Log.d("PostFragment", "onItemClick $position")
     }

 }