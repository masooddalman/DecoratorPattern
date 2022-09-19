package com.liliputdev.decoratorpattern.decorator.iceCreamParts

import com.liliputdev.decoratorpattern.R
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

    override fun calculatePrice(): Double? {
        return iceCream?.calculatePrice()?.plus(addStrawberryScoopPrice())
    }
    private fun addStrawberryScoopPrice():Double{
        return 0.33
    }

    //this is new
    override fun buildUI(): MutableList<Int>? {
        return iceCream?.buildUI()?.apply { add(R.drawable.strawberryscoop) }
    }
}