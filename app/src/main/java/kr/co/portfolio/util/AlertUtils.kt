package kr.co.portfolio.util

import android.content.Context
import androidx.appcompat.app.AlertDialog

/**
 * Created by kwon on 2021/06/25
 **/
class AlertUtils {

    companion object {


        fun showAlert(context : Context, message : String, positiveLabel : String? = "확인", positiveEvent : () -> Unit){

            AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(positiveLabel) { dialog, _ ->
                    dialog.dismiss()
                    positiveEvent()
                }.create().show()
        }

    }
}