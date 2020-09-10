package com.hvasoftware.constraintview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_constraint.*

class ConstraintActivity : AppCompatActivity() {

    private val TAG = ConstraintActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)


        // set width of view equal width of screen
        ConstraintView(this).setWidthRatioWithScreen(viewRed, 1, 0)

        // set height of view = 1/2 screen height
        ConstraintView(this).setHeightRatioWithScreen(viewRed, 2, 0)


        // width of view green will be equal 80% width of view red
        ConstraintView(this).setWidthRatioWithView(viewRed, viewGreen, 0.8, 0.0)

        // height of view green will be equal 20% height of view red
        ConstraintView(this).setHeightRatioWithView(viewRed, viewGreen, 0.2, 0.0)


        // width of view green will be equal 75% width of view red
        // width of view green will be equal 40% width of view red
        ConstraintView(this).getWidthAndHeightOfView(viewRed, object : IViewSizeCallback {
            override fun onSize(width: Int, height: Int) {
                ConstraintView(this@ConstraintActivity).setWidthAndHeightForView(
                    viewOrange,
                    width * 0.75,
                    height * 0.4
                )
            }
        })

        // width of view blue will be equal 85% width of screen
        // height of view green will be equal 40% height of screen
        ConstraintView(this@ConstraintActivity).setWidthAndHeightForView(
            viewBlue,
            ConstraintView(this).widthScreenPx() * 0.85,
            ConstraintView(this).heightScreenPx() * 0.4
        )


    }
}