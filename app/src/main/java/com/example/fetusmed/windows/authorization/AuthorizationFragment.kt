package com.example.fetusmed.windows.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_authorization.view.*

class AuthorizationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_authorization, container, false)

        view.btn_auth.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_authorizationFragment_to_homeFragment)
        }

        view.txt_restore_auth.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_authorizationFragment_to_restoreFragment)
        }

        return view
    }


}