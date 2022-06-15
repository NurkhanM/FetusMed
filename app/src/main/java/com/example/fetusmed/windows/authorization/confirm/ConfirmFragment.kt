package com.example.fetusmed.windows.authorization.confirm

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_confirm.*
import kotlinx.android.synthetic.main.fragment_confirm.view.*
import kotlinx.android.synthetic.main.fragment_restore.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ConfirmFragment : Fragment() {

    val cod = ArrayList<String>()

    private var timer: CountDownTimer? = null
    var timerInt: Int? = 12
    private val mHandler: Handler = Handler()

    private lateinit var vieww: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm, container, false)
        vieww = view

        for (i in 0..3){
            cod.add(i.toString())
        }


        view.btn_restore_confirm.setOnClickListener {
            if (view.edt_confirm1.text.trim().isNotEmpty() &&
                view.edt_confirm2.text.trim().isNotEmpty() &&
                view.edt_confirm3.text.trim().isNotEmpty() &&
                view.edt_confirm4.text.trim().isNotEmpty()
            ) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_confirmFragment_to_succesFullFragment)
            } else {
                Toast.makeText(requireContext(), "Пустое поле", Toast.LENGTH_SHORT).show()
            }

        }

        startCountDownTimer(12000)

        view.txt_center_aut_title8.setOnClickListener {
            timerInt = 12
            vieww.status_restore1.visibility = View.VISIBLE
            vieww.status_restore2.visibility = View.GONE
            startCountDownTimer(12000)
        }

//        view.edt_confirm1.requestFocus()
//        view.edt_confirm1.postDelayed(Runnable {
//            val keyboard = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
//            keyboard!!.showSoftInput(view.edt_confirm1, 0)
//        }, 200)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)

            if (view.edt_confirm1.text.isEmpty()){
                view.edt_confirm1.setText(cod[0])
            }

            CoroutineScope(Dispatchers.Main).launch {
                delay(500)
                if (view.edt_confirm2.text.isEmpty()){
                    view.edt_confirm2.setText(cod[1])
                }

                CoroutineScope(Dispatchers.Main).launch {
                    delay(500)
                    if (view.edt_confirm3.text.isEmpty()){
                        view.edt_confirm3.setText(cod[2])
                    }

                    CoroutineScope(Dispatchers.Main).launch {
                        delay(500)
                        if (view.edt_confirm4.text.isEmpty()){
                            view.edt_confirm4.setText(cod[3])
                        }
                    }
                }

            }




        }



        fun View.hideKeyboard() {
            val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(windowToken, 0)
        }
        autoFocusET(view.edt_confirm1, view.edt_confirm2)
        autoFocusET(view.edt_confirm2, view.edt_confirm3)
        autoFocusET(view.edt_confirm3, view.edt_confirm4)

        view.edt_confirm4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (view.edt_confirm4.text.length == 1){
                    view.hideKeyboard()
                }


            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        return view
    }


    private fun autoFocusET(editText: EditText, editText2: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(editText.text.length == 1){
                    editText2.requestFocus()
                }


            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1000) {
            override fun onTick(p0: Long) {
                timerInt = timerInt!! - 1
                vieww.txt_center_aut_title6.text = "через $timerInt секунд"
            }

            override fun onFinish() {
                vieww.status_restore1.visibility = View.GONE
                vieww.status_restore2.visibility = View.VISIBLE
            }
        }.start()
    }


}