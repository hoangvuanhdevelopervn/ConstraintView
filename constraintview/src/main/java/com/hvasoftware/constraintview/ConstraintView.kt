package com.hvasoftware.constraintview

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewTreeObserver

class ConstraintView(mContext: Context) {

    private var displayMetrics: DisplayMetrics = mContext.resources.displayMetrics


    fun widthScreenPx(): Int {
        return displayMetrics.widthPixels
    }

    fun heightScreenPx(): Int {
        return displayMetrics.heightPixels
    }

    fun widthScreenDp(): Float {
        return widthScreenPx() / displayMetrics.density
    }

    fun heightScreenDp(): Float {
        return heightScreenPx() / displayMetrics.density
    }

    fun setHeightRatioWithScreen(
        view: View,
        ratio: Int,
        bonus: Int
    ) {
        view.layoutParams.height = (heightScreenPx() / ratio) + bonus
    }

    fun setWidthRatioWithScreen(
        view: View,
        ratio: Int,
        bonus: Int
    ) {
        view.layoutParams.width = (widthScreenPx() / ratio) + bonus
    }

    fun getWidthAndHeightOfView(myView: View, iViewSizeCallback: IViewSizeCallback) {
        myView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                myView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                iViewSizeCallback.onSize(myView.width, myView.height)
            }
        })
    }

    fun setWidthAndHeightForView(myView: View, width: Double, height: Double) {
        myView.layoutParams.width = width.toInt()
        myView.layoutParams.height = height.toInt()
    }

    fun setHeightRatioWithView(viewParent: View, viewChild: View, ratio: Double, bonus: Double) {
        viewParent.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                viewParent.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val params = viewChild.layoutParams
                params.height = ((viewParent.height * ratio) + bonus).toInt()
                viewChild.layoutParams = params
            }
        })
    }


    fun setWidthRatioWithView(viewParent: View, viewChild: View, ratio: Double, bonus: Double) {
        viewParent.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                viewParent.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val params = viewChild.layoutParams
                params.width = ((viewParent.width * ratio) + bonus).toInt()
                viewChild.layoutParams = params
            }
        })
    }


}