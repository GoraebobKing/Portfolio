package kr.co.portfolio.ui.activity

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import kr.co.portfolio.R
import kr.co.portfolio.dao.PermissionModel
import kr.co.portfolio.databinding.ActivityIntroBinding
import kr.co.portfolio.util.PermissionCheck
import java.util.ArrayList

class IntroActivity : BindingActivity<ActivityIntroBinding>() {

    override fun getLayoutResId() = R.layout.activity_intro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init(){

        var handler = Handler()
        handler.postDelayed({

            PermissionCheck.getInstance()
                .with(this)
                .setPermission(arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_PHONE_STATE
                ))
                .setPermissionListener(object : PermissionActivity.PermissionListener {
                    override fun onPermissionGranted() {
                        startMainActivity()
                    }

                    override fun onPermissionDenied(deniedPermission: ArrayList<PermissionModel>) {

                    }
                })
                .check()
        }, 2000)

    }

    private fun startMainActivity(){

        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
