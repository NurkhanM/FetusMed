package com.example.fetusmed.windows.authorization.confirm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_confirm.view.*
import kotlinx.android.synthetic.main.fragment_restore.view.*

class ConfirmFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm, container, false)
        view.btn_restore_confirm.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_confirmFragment_to_succesFullFragment)
        }
        return view
    }


}