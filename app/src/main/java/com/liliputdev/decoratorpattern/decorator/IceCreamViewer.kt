package com.liliputdev.decoratorpattern.decorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
class IceCreamViewer {
    companion object{
        fun showIceCream(parts: Array<IceCream>):String? {
            return IceCreamDecorator(parts.reduce { a, b -> b.addPart(a) }).makeIceCream()!!
        }

        fun showIceCreamWithPrice(parts: Array<IceCream>): String? {
            val iceCreamDecorator = IceCreamDecorator(parts.reduce { a, b -> b.addPart(a) })
            return "${iceCreamDecorator.makeIceCream()} - price : ${
                (iceCreamDecorator.calculatePrice()
                    ?.times(100))?.div(100f)
            }$"
        }
    }
}