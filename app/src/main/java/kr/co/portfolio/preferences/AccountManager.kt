package kr.co.portfolio.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject


class AccountManager @Inject constructor(context : Context) {


    private val prefs = context.getSharedPreferences("sample",Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()


    fun setBoolean(key : String, value : Boolean){
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun getBoolean(key : String) : Boolean{
        return prefs.getBoolean(key, false)
    }
}