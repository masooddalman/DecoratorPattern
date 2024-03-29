package com.liliputdev.decoratorpattern.decorator.iceCreamParts

import android.util.Log
import com.liliputdev.decoratorpattern.R
import com.liliputdev.decoratorpattern.decorator.IceCream
import com.liliputdev.decoratorpattern.decorator.IceCreamDecorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class Sprinkles(private var iceCream: IceCream?=null) : IceCreamDecorator(iceCream) {

    override fun makeIceCream(): String {
        return iceCream?.makeIceCream() + addSprinkles()
    }

    fun addSprinkles(): String {
        return " + sprinkles"
    }
    override fun addPart(part: IceCream):IceCream
    {
        this.iceCream=part
        return this
    }

    override fun calculatePrice(): Double? {
        return iceCream?.calculatePrice()?.plus(addSprinklesPrice())
    }
    private fun addSprinklesPrice():Double{
        return 0.15
    }

    //this is new
    override fun buildUI(): MutableList<Int>? {
        return iceCream?.buildUI()?.apply { add(R.drawable.sprinkles) }
    }
}