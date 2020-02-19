package kr.co.portfolio.ui.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kr.co.portfolio.common.Log
import kr.co.portfolio.dao.PermissionModel
import java.util.ArrayList

class PermissionActivity : Activity() {

    private val TARGET = 9999

    companion object{
        var listener : PermissionListener? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permission = intent.getStringArrayExtra("permission")
        ActivityCompat.requestPermissions(this, permission!!, TARGET)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        var isAllGranted = false
        var arrGranted = ArrayList<PermissionModel>()
        if (TARGET == requestCode) {
            for (per in permissions) {

                for (granted in grantResults) {
                    val isGranted = granted == PackageManager.PERMISSION_GRANTED
                    var model = PermissionModel(per, isGranted)
                    arrGranted.add(model)
                    isAllGranted = isGranted

                    Log.e("퍼미션 체크 합니다 : $per   $isGranted")
                }
            }
        }

        if(isAllGranted) listener?.onPermissionGranted() else listener?.onPermissionDenied(arrGranted)

        finish()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (TARGET == requestCode) {
            finish()
        }
    }

    interface PermissionListener {
        fun onPermissionGranted()
        fun onPermissionDenied(deniedPermission: ArrayList<PermissionModel>)
    }
}