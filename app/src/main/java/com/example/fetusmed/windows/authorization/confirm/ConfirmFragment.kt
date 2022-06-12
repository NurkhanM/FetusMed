package com.example.fetusmed.windows.authorization.confirm

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_confirm.view.*
import kotlinx.android.synthetic.main.fragment_restore.view.*

class ConfirmFragment : Fragment() {

    private var timer: CountDownTimer? = null
    var timerInt: Int? = 12

    private lateinit var vieww: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm, container, false)
        vieww = view
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
        return view
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