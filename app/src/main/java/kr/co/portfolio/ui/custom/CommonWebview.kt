package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.util.Log
import android.webkit.*

/**
 * Created by kwon on 2020/09/04
 **/
class CommonWebview : WebView {

    private var listener : setOnEventListener? = null


    constructor(context: Context) : super(context, null)
    constructor(context: Context, attributeSet : AttributeSet) :  super(context, attributeSet) {
        initView()
    }

    private fun initView(){
        webChromeClient = WebViewChrom()
        webViewClient = WebClient()

        val setting: WebSettings = settings
        setting.javaScriptEnabled = true
        setting.loadsImagesAutomatically = true
        setting.setAppCacheEnabled(true)
        setting.domStorageEnabled = true
        setting.cacheMode = WebSettings.LOAD_NO_CACHE

        setting.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        cookieManager.setAcceptThirdPartyCookies(this, true)
    }

    fun addEventListener(listener : setOnEventListener){
        this.listener = listener
    }

    inner class WebViewChrom : WebChromeClient(){

    }

    inner class WebClient : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            listener?.onPageStarted(view, url)
        }


        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            listener?.onPageFinished(view, url)
            super.onPageFinished(view, url)
        }

        override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
            Log.e("onReceivedError" ,"onReceivedError : $errorCode    $failingUrl      $description")
        }
    }

    interface setOnEventListener{
        fun onPageStarted(view: WebView?, url: String?)
        fun onHandle(url : String)
        fun onPageFinished(view: WebView?, url: String?)
    }

}