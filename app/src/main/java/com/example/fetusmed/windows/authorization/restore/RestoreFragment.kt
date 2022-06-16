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
        fun String.isValidEmail() = isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
        view.btn_restore.setOnClickListener {
            if (view.restoreEditEmailRestore.text?.trim()?.isNotEmpty() == true ){
                if (view.restoreEditEmailRestore.text.toString().isValidEmail()){
                    val sendData = RestoreFragmentDirections.actionRestoreFragmentToConfirmFragment(view.restoreEditEmailRestore.text.toString())
                    Navigation.findNavController(view).navigate(sendData)
                }else{
                    Toast.makeText(requireContext(), "Введите почтовый адресс!", Toast.LENGTH_SHORT).show()
                }
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