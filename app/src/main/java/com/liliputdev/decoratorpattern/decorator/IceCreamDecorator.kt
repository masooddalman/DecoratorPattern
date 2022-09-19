package com.liliputdev.decoratorpattern.decorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
open class IceCreamDecorator(private var iceCream: IceCream?) : IceCream {
    override fun makeIceCream(): String? {
        return iceCream?.makeIceCream()
    }

    override fun addPart(part: IceCream): IceCream {
        this.iceCream = part
        return this
    }

    override fun calculatePrice(): Double? {
        return iceCream?.calculatePrice()
    }

    //this is new
    override fun buildUI(): MutableList<Int>? {
        return iceCream?.buildUI()
    }
}
