package com.example.fetusmed.windows.authorization.newPassword

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.fetusmed.R
import kotlinx.android.synthetic.main.fragment_new_password.view.*


class NewPasswordFragment : Fragment() {

     lateinit var dialog: Dialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_new_password, container, false)

        dialog =  Dialog(requireContext())

        view.btn_newPas.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_newPasswordFragment_to_succesFullFragment)
        }

        view.btn_newPas_cancel.setOnClickListener {
            alertDialogCancel(view)
        }

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                alertDialogCancel(view)
            }
        })

        return view
    }


   private fun alertDialogCancel(view: View){

       dialog.setContentView(R.layout.dialog_new_password)
       dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
       val buttonYES = dialog.findViewById<Button>(R.id.dialog_yes)
       val buttonNO = dialog.findViewById<Button>(R.id.dialog_no)
       buttonYES.setOnClickListener {
           Navigation.findNavController(view)
               .navigate(R.id.action_newPasswordFragment_to_authorizationFragment)
           dialog.dismiss()
       }
       buttonNO.setOnClickListener {
           dialog.dismiss()
       }
       dialog.show()

   }



}