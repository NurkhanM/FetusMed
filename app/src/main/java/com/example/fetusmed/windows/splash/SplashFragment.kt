package com.example.fetusmed.windows.splash

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_splash, container, false)

        (activity as AppCompatActivity).window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.fon);
        // Метод для показа полно экранного режима
        fullScreen()

        // Таймер для показа Рекламы
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_authorizationFragment)
            (activity as AppCompatActivity).window.statusBarColor = ContextCompat.getColor(requireContext(),R.color.white)
        }

        return view

    }

    @SuppressLint("ObsoleteSdkInt")
    fun fullScreen() {

        val uiOptions = (activity as AppCompatActivity).window.decorView.systemUiVisibility
        var newUiOptions = uiOptions

        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
        (activity as AppCompatActivity).window.decorView.systemUiVisibility = newUiOptions
    }


}