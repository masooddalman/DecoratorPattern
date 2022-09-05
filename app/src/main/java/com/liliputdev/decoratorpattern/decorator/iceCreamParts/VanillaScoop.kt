package com.liliputdev.decoratorpattern.decorator.iceCreamParts

import android.util.Log
import com.liliputdev.decoratorpattern.decorator.IceCream
import com.liliputdev.decoratorpattern.decorator.IceCreamDecorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class VanillaScoop(private var iceCream: IceCream? = null) : IceCreamDecorator(iceCream) {
    override fun makeIceCream(): String {
        return iceCream?.makeIceCream() + addVanillaScope()
    }

    private fun addVanillaScope(): String {
        return " + vanilla"
    }

    override fun addPart(part: IceCream): IceCream {
        this.iceCream = part
        return this
    }

    override fun calculatePrice(): Double? {
        return iceCream?.calculatePrice()?.plus(addVanillaScoopPrice())
    }

    private fun addVanillaScoopPrice(): Double {
        return 0.33
    }
}