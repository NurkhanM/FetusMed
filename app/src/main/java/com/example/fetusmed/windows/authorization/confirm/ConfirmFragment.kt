package com.example.fetusmed.windows.authorization.confirm

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.res.ColorStateList
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
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_confirm.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ConfirmFragment : Fragment() {

    val emailCode = arrayOf(1, 2, 3, 4)
    val edtCode = arrayOf(3, 3, 3, 3)
    private var email = "MXsdasdasda00@gmail.com"

    private var timer: CountDownTimer? = null
    var timerInt: Int? = 120
    private val mHandler: Handler = Handler()
    private val args: ConfirmFragmentArgs by navArgs()

    private lateinit var vieww: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm, container, false)
        vieww = view
        email = args.email


        val sizeEmail = email.substring(2, email.indexOf('@') - 2).length
        var sizeEmailString = ""
        for (i in 0 until sizeEmail) {
            sizeEmailString += "*"
        }
        email = email.replace(email.substring(2, email.indexOf('@') - 2), sizeEmailString)

        view.txt_center_confirm_title3.text = "Мы отправили код подтверждения \n на адрес $email"

        view.btn_restore_confirm.isClickable = false
        view.btn_restore_confirm.setOnClickListener {
            if (view.edt_confirm1.text.trim().isNotEmpty() &&
                view.edt_confirm2.text.trim().isNotEmpty() &&
                view.edt_confirm3.text.trim().isNotEmpty() &&
                view.edt_confirm4.text.trim().isNotEmpty()
            ) {
                if (view.edt_confirm1.text.toString().toInt() == edtCode[0] &&
                    view.edt_confirm2.text.toString().toInt() == edtCode[1] &&
                    view.edt_confirm3.text.toString().toInt() == edtCode[2] &&
                    view.edt_confirm4.text.toString().toInt() == edtCode[3]
                ) {
                    Navigation.findNavController(view)
                        .navigate(R.id.action_confirmFragment_to_newPasswordFragment)
                } else {
                    view.edt_confirm1.requestFocus()
                    view.edt_confirm1.postDelayed(Runnable {
                        val keyboard = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
                        keyboard!!.showSoftInput(view.edt_confirm1, 0)
                    }, 200)
                    vieww.btn_restore_confirm.isClickable = false
                    vieww.btn_restore_confirm.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.button_fon)
                    view.status_restore2.visibility = View.VISIBLE
                    view.edt_confirm1.setText("")
                    view.edt_confirm1.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.text_error)
                    view.edt_confirm2.setText("")
                    view.edt_confirm2.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.text_error)
                    view.edt_confirm3.setText("")
                    view.edt_confirm3.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.text_error)
                    view.edt_confirm4.setText("")
                    view.edt_confirm4.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.text_error)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2500)
                        view.status_restore2.visibility = View.GONE
                        view.edt_confirm1.backgroundTintList = ColorStateList.valueOf(R.color.black_txt3)
                        view.edt_confirm2.backgroundTintList = ColorStateList.valueOf(R.color.black_txt3)
                        view.edt_confirm3.backgroundTintList = ColorStateList.valueOf(R.color.black_txt3)
                        view.edt_confirm4.backgroundTintList = ColorStateList.valueOf(R.color.black_txt3)
                    }
                }

            } else {
                Toast.makeText(requireContext(), "Пустое поле", Toast.LENGTH_SHORT).show()
            }

        }

        vieww.txt_center_aut_title6.isClickable = false
        startCountDownTimer(120000)


        view.txt_center_aut_title6.setOnClickListener {
            timerInt = 120
            startCountDownTimer(120000)
            vieww.txt_center_aut_title6.text = ""
            vieww.txt_center_aut_title6.isClickable = false
        }

        view.edt_confirm1.requestFocus()
        view.edt_confirm1.postDelayed(Runnable {
            val keyboard = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
            keyboard!!.showSoftInput(view.edt_confirm1, 0)
        }, 200)


//        CoroutineScope(Dispatchers.Main).launch {
//            delay(1000)
//
//            if (view.edt_confirm1.text.isEmpty()) {
//                view.edt_confirm1.setText(cod[0])
//            }
//
//            CoroutineScope(Dispatchers.Main).launch {
//                delay(500)
//                if (view.edt_confirm2.text.isEmpty()) {
//                    view.edt_confirm2.setText(cod[1])
//                }
//
//                CoroutineScope(Dispatchers.Main).launch {
//                    delay(500)
//                    if (view.edt_confirm3.text.isEmpty()) {
//                        view.edt_confirm3.setText(cod[2])
//                    }
//
//                    CoroutineScope(Dispatchers.Main).launch {
//                        delay(500)
//                        if (view.edt_confirm4.text.isEmpty()) {
//                            view.edt_confirm4.setText(cod[3])
//                        }
//                    }
//                }
//
//            }
//        }

        autoFocusET(view.edt_confirm1, view.edt_confirm2)
        autoFocusET(view.edt_confirm2, view.edt_confirm3)
        autoFocusET(view.edt_confirm3, view.edt_confirm4)

        prIsEmpty(view.edt_confirm1, view.edt_confirm2, view.edt_confirm3, view.edt_confirm4)

        view.btn_confirm_cancel.setOnClickListener {
            activity?.onBackPressed()
        }

        return view
    }

   private fun View.hideKeyboard() {
        val inputManager =
            context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }


    private fun autoFocusET(editText: EditText, editText2: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (editText.text.length == 1) {
                    editText2.requestFocus()
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
    private fun prIsEmpty(editText: EditText, editText2: EditText, editText3: EditText, editText4: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (editText.text.length == 1 &&
                    editText2.text.length == 1 &&
                    editText3.text.length == 1 &&
                    editText4.text.length == 1 ) {
                    vieww.hideKeyboard()
                    vieww.btn_restore_confirm.isClickable = true
                    vieww.btn_restore_confirm.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.fon)
                }
            }
        })
        editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (editText.text.length == 1 &&
                    editText2.text.length == 1 &&
                    editText3.text.length == 1 &&
                    editText4.text.length == 1 ) {
                    vieww.hideKeyboard()
                    vieww.btn_restore_confirm.isClickable = true
                    vieww.btn_restore_confirm.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.fon)
                }
            }
        })
        editText3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (editText.text.length == 1 &&
                    editText2.text.length == 1 &&
                    editText3.text.length == 1 &&
                    editText4.text.length == 1 ) {
                    vieww.hideKeyboard()
                    vieww.btn_restore_confirm.isClickable = true
                    vieww.btn_restore_confirm.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.fon)
                }
            }
        })
        editText4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
                if (editText.text.length == 1 &&
                    editText2.text.length == 1 &&
                    editText3.text.length == 1 &&
                    editText4.text.length == 1 ) {
                    vieww.hideKeyboard()
                    vieww.btn_restore_confirm.isClickable = true
                    vieww.btn_restore_confirm.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.fon)
                }
            }
        })
    }

    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1000) {
            override fun onTick(p0: Long) {
                timerInt = timerInt!! - 1
                vieww.txt_center_aut_title5.text =
                    "Получить новый код можно\n через $timerInt секунд"
            }

            override fun onFinish() {
                vieww.txt_center_aut_title5.text = "Не получили код?"
                vieww.txt_center_aut_title6.text = " Получите новый."
                vieww.txt_center_aut_title6.setTextColor(resources.getColor(R.color.fon))
                vieww.txt_center_aut_title6.isClickable = true
            }
        }.start()
    }

}