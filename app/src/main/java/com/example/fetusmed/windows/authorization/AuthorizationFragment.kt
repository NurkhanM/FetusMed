package com.example.fetusmed.windows.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_authorization.view.*

class AuthorizationFragment : Fragment() {

    val email = "admin@mail.ru"
    val password = "123456"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_authorization, container, false)

        view.btn_auth.setOnClickListener {
//            if (view.authEditEmail.text?.trim()?.length != 0 && view.authEditPassword.text?.trim()?.length != 0){
//                if (view.authEditEmail.text.toString() == "admin@mail.ru" &&
//                    view.authEditPassword.text.toString() == "123456"){
//                    Toast.makeText(requireContext(), "Добро пожаловать!", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_authorizationFragment_to_homeFragment)
//                }else{
//                    Toast.makeText(requireContext(), "Неправильный \n Логин или Пароль!", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
//            }

        }

        view.txt_restore_auth.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_authorizationFragment_to_restoreFragment)
        }

        return view
    }


}