package com.liliputdev.decoratorpattern.decorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class IceCreamViewer {
    companion object{
        fun showIceCream(parts: Array<IceCream>):String? {
            return IceCreamDecorator(parts.reduce { a, b -> b.addPart(a) }).makeIceCream()!!
        }
    }
}