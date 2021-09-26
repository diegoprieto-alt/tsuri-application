package com.misiontic2022.app.tsuri

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.setttings,container    ,false)
    }

    companion object{
        @JvmStatic
        fun newInstance(param1:String,param2:String) = SettingsFragment()
    }
}