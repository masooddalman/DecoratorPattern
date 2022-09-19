package com.liliputdev.decoratorpattern.decorator.iceCreamParts

import android.util.Log
import com.liliputdev.decoratorpattern.R
import com.liliputdev.decoratorpattern.decorator.IceCream
import com.liliputdev.decoratorpattern.decorator.IceCreamDecorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class ChocolateScoop(var iceCream: IceCream?=null) : IceCreamDecorator(iceCream) {

    override fun makeIceCream(): String {
        return iceCream?.makeIceCream() + addChocolateScope()
    }

    private fun addChocolateScope(): String {
        return " + chocolate"
    }

    override fun addPart(part: IceCream):IceCream
    {
        this.iceCream=part
        return this
    }

    override fun calculatePrice(): Double? {
        return iceCream?.calculatePrice()?.plus(addChocolateScoopPrice())
    }
    private fun addChocolateScoopPrice():Double{
        return 0.33
    }
    //this is new
    override fun buildUI(): MutableList<Int>? {
        return iceCream?.buildUI()?.apply { add(R.drawable.chocolatescoop) }
    }
}