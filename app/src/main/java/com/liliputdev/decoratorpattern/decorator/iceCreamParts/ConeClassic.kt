package com.liliputdev.decoratorpattern.decorator.iceCreamParts

import com.liliputdev.decoratorpattern.decorator.IceCream

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class ConeClassic : IceCream {
    override fun makeIceCream(): String {
        return "Classic Cone"
    }

    override fun addPart(part: IceCream):IceCream
    {
        return this
    }

    override fun calculatePrice(): Double? {
        return 0.75
    }
}