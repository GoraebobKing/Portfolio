package kr.co.portfolio.common

import android.util.Log
import kr.co.portfolio.BuildConfig

class Log {

    companion object {
        private var TAG  = "[Portfolio]"

        fun d(message : String) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.d (TAG, getLogText(message) )

        }

        fun i(message : String) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.i (TAG, getLogText(message) )

        }

        fun e(message : String) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.e (TAG, getLogText(message) )

        }

        fun obj (obj: Any) {
            if (!BuildConfig.IS_DEBUG) {
                return
            }

            Log.e (TAG, getLogText("${obj}"))
        }


        fun getLogText(message: String) : String{

            var stack = Throwable().stackTrace[2]
            var tag = ""

            var temp = stack.className
            if(temp != null){
                var lastDotPos = temp.lastIndexOf(".")
                tag = temp.substring(lastDotPos + 1)
            }

            var methodName = stack.methodName
            var lineNumber = stack.lineNumber

            return ("[$tag] $methodName()  [$lineNumber] >> $message")
        }
    }
}