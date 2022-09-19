package com.liliputdev.decoratorpattern.decorator.iceCreamParts

import com.liliputdev.decoratorpattern.R
import com.liliputdev.decoratorpattern.decorator.IceCream
import com.liliputdev.decoratorpattern.decorator.IceCreamDecorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class ConeSpecial():IceCream {
    override fun makeIceCream(): String {
        return "Special Cone"
    }

    override fun addPart(part: IceCream):IceCream
    {
        return this
    }

    override fun calculatePrice(): Double? {
        return 0.5
    }
    //this is new
    override fun buildUI(): MutableList<Int>? {
        return mutableListOf(R.drawable.special_cone)
    }
}