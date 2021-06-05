package kr.co.portfolio.util

import android.util.Log
import kr.co.portfolio.BuildConfig

class Logger {

    companion object {
        private var TAG = "[PortFolio]"

        fun d(message: String) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.d(TAG, getLogText(message))

        }

        fun i(message: String) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.i(TAG, getLogText(message))

        }

        fun e(message: String) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.e(TAG, getLogText(message))

        }

        fun obj(obj: Any) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.e(TAG, getLogText("$obj"))
        }


        private fun getLogText(message: String): String {

            val stack = Throwable().stackTrace[2]
            var tag = ""

            val temp = stack.className
            if (temp != null) {
                val lastDotPos = temp.lastIndexOf(".")
                tag = temp.substring(lastDotPos + 1)
            }

            val methodName = stack.methodName
            val lineNumber = stack.lineNumber

            return ("[$tag] $methodName()  [$lineNumber] >> $message")
        }
    }
}