package kr.co.portfolio.ui.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Looper
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import com.google.android.gms.location.*
import kr.co.portfolio.util.AlertUtils
import kr.co.portfolio.util.Logger
import kr.co.portfolio.util.PermissionState
import kr.co.portfolio.util.doublePermission
import kr.co.portfolio.viewmodel.BaseViewModel

/**
 * Created by kwon on 2021/07/07
 **/
abstract class LocationActivity<T : ViewDataBinding, U : BaseViewModel> : BaseActivity<T, U>() {

    abstract fun locationPermissionCancel()
    abstract fun gpsCancel()
    abstract fun getGpsLocation(lati: Double, longti: Double)

    private var providerClient: FusedLocationProviderClient? = null

    override fun onDestroy() {
        providerClient?.removeLocationUpdates(locationCallBack)
        super.onDestroy()
    }

    fun settingLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                AlertUtils.showAlert(this, "위치권한을 허용해 주세요.", positiveEvent = {
                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${packageName}"))
                    intent.addCategory(Intent.CATEGORY_DEFAULT)
                    locationLaunch.launch(intent)
                }, negativeEvent = {
                    Logger.e("Location Permission Cancel")
                    locationPermissionCancel()
                })
        } else {
            gpsEnableCheckAndStart()
        }
    }


    private fun gpsEnableCheckAndStart() {
        val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //GPS 팝업 필요
            gpsCancel()
        } else {
            providerClient = LocationServices.getFusedLocationProviderClient(this)
            onConnected()
        }
    }


    @Suppress("MissingPermission")
    fun onConnected() {
        val locationRequest = LocationRequest.create().apply {
            interval = 2000
            fastestInterval = 3000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        val builder = LocationSettingsRequest.Builder()
        val settingsClient = LocationServices.getSettingsClient(this)
        val task = settingsClient.checkLocationSettings(builder.build())

        task.addOnSuccessListener {
            providerClient?.requestLocationUpdates(locationRequest, locationCallBack, Looper.getMainLooper())
        }

        task.addOnFailureListener{exception ->
            Logger.e("addOnFailureListener Error $exception ")
        }
    }

    @Suppress("MissingPermission")
    private var locationCallBack = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult?) {
            if(result != null){
                result.let {
                    try {
                        getGpsLocation(it.lastLocation.latitude, it.lastLocation.longitude)
                    } catch (e: Exception) { }
                }
                providerClient?.removeLocationUpdates(this)
            } else {
                providerClient?.lastLocation?.addOnSuccessListener {

                    if (it != null) {
                        try {
                            getGpsLocation(it.latitude, it.longitude)
                        } catch (e: Exception) { }
                    }
                }
            }
        }
    }

    fun permissionCheck() {

        val permissionArray = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
        permissionLaunch.launch(permissionArray)
    }

    private val permissionLaunch = doublePermission(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), object : PermissionState() {
        override fun granted() {
            Logger.e("권한 허용")
            settingLocation()
        }

        override fun rejected() {
            Logger.e("권한 거부")
            settingLocation()
        }

        override fun denied() {
            Logger.e("권한 거부")
            locationPermissionCancel()
        }
    })

    private val locationLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        settingLocation()
    }
}