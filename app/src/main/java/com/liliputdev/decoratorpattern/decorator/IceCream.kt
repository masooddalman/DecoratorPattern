package com.liliputdev.decoratorpattern.decorator

/**
 * Created by Masood Dalman on 9/4/2022.
 */
interface IceCream {
    fun makeIceCream(): String?
    fun addPart(part: IceCream):IceCream
    fun calculatePrice():Double?
    fun buildUI():MutableList<Int>?// this line is new
}