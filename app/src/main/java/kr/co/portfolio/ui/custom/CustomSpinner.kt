package kr.co.portfolio.ui.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.*
import android.widget.PopupWindow
import androidx.recyclerview.widget.RecyclerView
import kr.co.portfolio.ui.adapter.SpinnerAdapter
import kr.co.portfolio.R

/**
 * Created by kwon on 2020/09/23
 * https://github.com/skydoves/PowerSpinner
 **/
class CustomSpinner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr : Int = 0) : View(context, attrs, defStyleAttr) {


    enum class GRAVITY_TYPE_TEXT{
        LEFT, CENTER, RIGHT
    }

    private lateinit var itemList : MutableList<String>

    private var popupWindow : PopupWindow? = null
    private lateinit var listView : View
    private lateinit var meNuListView : RecyclerView

    private var showPopupFlag = false

    init {

        attrs.let {

            val typeArray = context.obtainStyledAttributes(it, R.styleable.CustomSpinner)

            val arrayId =  typeArray.getResourceId(R.styleable.CustomSpinner_spinner_item_list, 0)
            typeArray.getDimension(R.styleable.CustomSpinner_spinner_item_height, 30f)
            typeArray.getColor(R.styleable.CustomSpinner_spinner_item_color, Color.WHITE)
            typeArray.getDimension(R.styleable.CustomSpinner_spinner_item_text_size, 15f)
            typeArray.getColor(R.styleable.CustomSpinner_spinner_item_text_color, Color.BLACK)
            typeArray.getResourceId(R.styleable.CustomSpinner_spinner_item_text_font, Color.WHITE)

            itemList = context.resources.getStringArray(arrayId).toMutableList()

            typeArray.recycle()
        }

        listView = LayoutInflater.from(context).inflate(R.layout.custom_spinner, null, false)
        meNuListView = listView.findViewById(R.id.rv_spinner_list)
        val adapter = SpinnerAdapter()
        adapter.updateItem(itemList)
        meNuListView.adapter = adapter
        popupWindow = PopupWindow(listView, width, WindowManager.LayoutParams.WRAP_CONTENT, true)
        popupWindow?.isOutsideTouchable = true
        popupWindow?.setOnDismissListener {
            showPopupFlag = false
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(event?.action == MotionEvent.ACTION_DOWN ){
            Log.e("asdasd", "선택")
             if(!showPopupFlag){
                 popupWindow?.showAsDropDown(this)
                 post {
                     popupWindow?.update(width, meNuListView.height)
                 }
             }
        }

        return super.onTouchEvent(event)
    }
}