package com.liliputdev.decoratorpattern.decorator

import android.util.Log
import com.liliputdev.decoratorpattern.decorator.iceCreamParts.ConeClassic
import com.liliputdev.decoratorpattern.decorator.iceCreamParts.ConeSpecial
import com.liliputdev.decoratorpattern.decorator.iceCreamParts.Sprinkles
import java.math.RoundingMode
import java.text.DecimalFormat

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

        fun calculateIceCreamPrice(parts: Array<IceCream>): String?{
            val iceCreamDecorator = IceCreamDecorator(parts.reduce { a, b -> b.addPart(a) })
            var res=iceCreamDecorator.calculatePrice()
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            Log.v("masood","price:$res \t ${df.format(res)}")
            return df.format(res)
        }

        /**
         * This method returns array of drawable resources based on the input ice cream array.
         *
         * the first input item must be ConeClassic() or ConeSpecial() and the last item must be Sprinkles() object
         *
         * @return array of drawable resource
         */
        fun buildIceCreamResourceList(parts: Array<IceCream>):MutableList<Int>?{
            if(parts.last() is Sprinkles && (parts.first() is ConeClassic || parts.first() is ConeSpecial)) {
                val iceCreamDecorator = IceCreamDecorator(parts.reduce { a, b -> b.addPart(a) })
                return iceCreamDecorator.buildUI()
            }
            else {
                throw NoSuchElementException("the first input item must be ConeClassic() or ConeSpecial() and the last item must be Sprinkles() object")
            }
        }
    }
}