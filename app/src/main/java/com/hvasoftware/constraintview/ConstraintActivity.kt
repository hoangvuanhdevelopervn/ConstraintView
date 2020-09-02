package com.hvasoftware.constraintview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_constraint.*

class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)


        // set width of view equal width of screen
        ConstraintView(this).setWidthRatioWithScreen(viewRed, 1, 0)
        // set height of view = 1/2 screen height
        ConstraintView(this).setHeightRatioWithScreen(viewRed, 2, 0)


        // width of view green will be equal 1/2 view red
        ConstraintView(this).setWidthRatioWithView(viewRed, viewGreen, 0.5, 0.0)
        // height of view green will be equal 1/2 view red
        ConstraintView(this).setHeightRatioWithView(viewRed, viewGreen, 0.5, 0.0)


        // width of view green will be equal 1/2 view red
        ConstraintView(this).setWidthRatioWithView(viewRed, viewOrange, 0.7, 0.0)

        // width of view green will be equal 1/2 view red
        ConstraintView(this).setHeightRatioWithView(viewRed, viewOrange, 0.1, 0.0)

    }
}