package com.example.fetusmed.windows.authorization.restore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_restore.view.*

class RestoreFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_restore, container, false)

        view.btn_restore.setOnClickListener {
            if (view.authEditEmailRestore.text?.trim()?.isNotEmpty() == true){
                Navigation.findNavController(view).navigate(R.id.action_restoreFragment_to_confirmFragment)
            } else {
                Toast.makeText(requireContext(), "Заполните поле!", Toast.LENGTH_SHORT).show()
            }

        }
        view.btn_restore_cancel.setOnClickListener {
            activity?.onBackPressed()
        }
        return view
    }


}