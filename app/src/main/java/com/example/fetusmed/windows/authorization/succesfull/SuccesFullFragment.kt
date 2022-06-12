package com.example.fetusmed.windows.authorization.succesfull

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_authorization.view.*
import kotlinx.android.synthetic.main.fragment_succes_full.view.*

class SuccesFullFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_succes_full, container, false)

        view.btn_restore_success_full.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_succesFullFragment_to_homeFragment)
        }
        return view
    }


}