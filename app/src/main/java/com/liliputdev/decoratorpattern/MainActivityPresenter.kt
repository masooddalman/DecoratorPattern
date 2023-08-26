package com.liliputdev.decoratorpattern

import android.app.Activity
import androidx.constraintlayout.widget.ConstraintLayout
import com.liliputdev.decoratorpattern.decorator.IceCream

/**
 * Created by Masood Dalman on 9/18/2022.
 */
interface MainActivityPresenter {
    //initializing the presenter because we don't want to use any DI.
    fun start(activity:Activity,view: MainActivityView)
    //calls when the ice cream is ready for building the UI
    fun buildView(parts: Array<IceCream>, rootLayout:ConstraintLayout)
    //calls when we need a random ice cream
    fun getRandomIceCreamPartArray(size:Int,specialCone:Boolean)
    //call when we need to get price and send show it in UI
    fun getPriceAndShowIt(parts: Array<IceCream>)
}