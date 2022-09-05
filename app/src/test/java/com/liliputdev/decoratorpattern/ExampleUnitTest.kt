package com.liliputdev.decoratorpattern

import com.liliputdev.decoratorpattern.decorator.IceCreamDecorator
import com.liliputdev.decoratorpattern.decorator.IceCreamViewer
import com.liliputdev.decoratorpattern.decorator.iceCreamParts.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun iceCreamDecorator_test() {
        val res=IceCreamDecorator(
            Sprinkles(
                StrawberryScoop(
                    VanillaScoop(
                        ChocolateScoop(
                            ConeClassic()
                        )
                    )
                )
            )
        ).makeIceCream()
        assertEquals(
            "Classic Cone + chocolate + vanilla + strawberry + sprinkles",
            res)
    }

    @Test
    fun iceCreamViewer_test() {
        val myIceCream=IceCreamViewer.showIceCream(arrayOf(
            ConeSpecial(),
            ChocolateScoop(),
            VanillaScoop(),
            StrawberryScoop(),
            Sprinkles()
        ))
        assertEquals(
            "Special Cone + chocolate + vanilla + strawberry + sprinkles",
            myIceCream
        )
    }

    @Test
    fun iceCreamViewerWithPrice_test()
    {
        val myIceCream=IceCreamViewer.showIceCreamWithPrice(arrayOf(
            ConeSpecial(),
            ChocolateScoop(),
            VanillaScoop(),
            StrawberryScoop(),
            Sprinkles()
        ))
        assertEquals(
            "Special Cone + chocolate + vanilla + strawberry + sprinkles - price : 1.64$",
            myIceCream
        )
    }
}