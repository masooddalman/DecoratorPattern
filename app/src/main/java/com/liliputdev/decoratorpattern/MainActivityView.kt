package com.liliputdev.decoratorpattern

import android.view.View
import com.liliputdev.decoratorpattern.decorator.IceCream

/**
 * Created by Masood Dalman on 9/18/2022.
 */
interface MainActivityView {

    //calls when the ice cream is ready to show
    fun iceCreamViewReady(iceCream:MutableList<IceCream>)
    //calls when we want to show the price
    fun showPrice(price:String?)
}