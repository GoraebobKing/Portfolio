package kr.co.portfolio.util

import android.app.Activity
import android.content.Intent
import kr.co.portfolio.ui.activity.PermissionActivity

class PermissionCheck {

    companion object{
        private lateinit var instance : PermissionCheck

        @Synchronized
        fun getInstance(): PermissionCheck {

            if(!::instance.isInitialized){
                instance = PermissionCheck()
            }

            return instance
        }
    }

    private lateinit var activity : Activity

    private var listener : PermissionActivity.PermissionListener? = null
    private var permission : Array<String>? = null

    fun with(activity: Activity): PermissionCheck {
        this.activity = activity
        return this
    }

    fun setPermissionListener(listener: PermissionActivity.PermissionListener): PermissionCheck {
        this.listener = listener
        return this
    }

    fun setPermission(permission: Array<String>): PermissionCheck {
        this.permission = permission
        return this
    }

    fun check() {
        val intent = Intent(activity, PermissionActivity::class.java)
        intent.putExtra("permission", permission)
        activity.startActivity(intent)
        activity.overridePendingTransition(0, 0)
        PermissionActivity.listener = this.listener
    }


}