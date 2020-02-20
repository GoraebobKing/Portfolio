package kr.co.portfolio.ui.activity

import android.annotation.TargetApi
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.core.app.ActivityCompat
import kr.co.portfolio.R
import kr.co.portfolio.common.Log
import kr.co.portfolio.dao.PermissionModel
import java.util.ArrayList

class PermissionActivity : Activity() {

    companion object{
        var listener : PermissionListener? = null
    }

    private val TARGET = 9999
    private var selectMessage = ""
    private var needMessage = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        needMessage = intent.getStringExtra("needMessage")
        selectMessage = intent.getStringExtra("selectMessage")

        val permission = intent.getStringArrayExtra("permission")
        ActivityCompat.requestPermissions(this, permission!!, TARGET)
    }

    @TargetApi(23)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        var isAllGranted = true
        var arrGranted = ArrayList<PermissionModel>()
        if (TARGET == requestCode) {

            for (i in 0 until permissions.size){

                val isGranted = grantResults[i] == PackageManager.PERMISSION_GRANTED

                when(isGranted){

                    true -> {
                        var model = PermissionModel(permissions[i], isGranted)
                        arrGranted.add(model)
                    }

                    false -> {

                        isAllGranted = false

                        //다시보기을 하지 않았을경우
                        if(shouldShowRequestPermissionRationale(permissions[i])){
                            if(selectMessage.compareTo("") == 0){
                                showMessageAlert("셀렉트 아모르파티", true, arrGranted)
                            } else {
                                showMessageAlert(selectMessage, true, arrGranted)
                            }
                        } else {
                            if(needMessage.compareTo("") == 0){
                                showMessageAlert("니드 아모르파티", true, arrGranted)
                            } else {
                                showMessageAlert(needMessage, true, arrGranted)
                            }
                        }
                    }
                }

                Log.e("퍼미션 체크 합니다 : ${permissions[i]}   $isGranted")
            }
        }

        if(isAllGranted){
            listener?.onPermissionGranted()
            finish()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (TARGET == requestCode) {
            finish()
        }
    }

    private fun showMessageAlert(msg : String, isNeed : Boolean = false, arrGranted : ArrayList<PermissionModel>){

        var builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setMessage(msg)


        if(isNeed){
            builder.setPositiveButton(getString(R.string.btn_setting), DialogInterface.OnClickListener {
                    dialog, _ ->
                dialog.dismiss()
                var intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.data = Uri.parse("package:$packageName")
                startActivityForResult(intent, TARGET)
            })

        } else {
            builder.setPositiveButton(getString(R.string.btn_ok), DialogInterface.OnClickListener {
                    dialog, _ ->
                dialog.dismiss()
                listener?.onPermissionDenied(arrGranted)
                finish()
            })
        }

        builder.setNegativeButton(getString(R.string.btn_cancel), DialogInterface.OnClickListener {
                dialog, _ ->
            dialog.dismiss()
            listener?.onPermissionDenied(arrGranted)
            finish()

        })
        builder.show()
    }

    interface PermissionListener {
        fun onPermissionGranted()
        fun onPermissionDenied(deniedPermission: ArrayList<PermissionModel>)
    }


}