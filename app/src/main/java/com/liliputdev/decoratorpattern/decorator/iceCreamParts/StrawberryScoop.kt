package com.liliputdev.decoratorpattern.decorator.iceCreamParts

import android.util.Log
import com.liliputdev.decoratorpattern.decorator.IceCream
import com.liliputdev.decoratorpattern.decorator.IceCreamDecorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class StrawberryScoop(private var iceCream: IceCream?=null): IceCreamDecorator(iceCream) {
    override fun makeIceCream(): String {
        return iceCream?.makeIceCream()+addStrawberry()
    }

    private fun addStrawberry():String{
        return " + strawberry"
    }

    override fun addPart(part: IceCream):IceCream
    {
        this.iceCream=part
        return this
    }
}