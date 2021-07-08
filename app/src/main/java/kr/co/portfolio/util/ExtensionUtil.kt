package kr.co.portfolio.util

import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

/**
 * Created by kwon on 2021/02/08
 **/

fun View.visible() {
    if(this.visibility != View.VISIBLE) this.visibility = View.VISIBLE
}

fun View.gone() {
    if(this.visibility != View.GONE) this.visibility = View.GONE
}

fun View.invisible() {
    if(this.visibility != View.INVISIBLE) this.visibility = View.INVISIBLE
}

fun AppCompatActivity.doublePermission(permission: Array<String>, state: PermissionState? = null): ActivityResultLauncher<Array<String>> {
    return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->

        var isAllGrant = true
        result.entries.forEach {
            Logger.e("it.key : ${it.key}, ${it.value}")

            if (!it.value) {
                isAllGrant = false
            }
        }

        if (isAllGrant) {
            state?.granted()
        } else {

            var isReject = false
            permission.forEach {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, it)) {
                    isReject = true
                    return@forEach
                }
            }

            if (isReject) {
                state?.rejected()
            } else {
                state?.denied()
            }
        }
    }
}
