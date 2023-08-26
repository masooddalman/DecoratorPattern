package com.liliputdev.decoratorpattern

import android.app.Activity
import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import android.R.layout
import android.util.Log
import android.view.View
import android.widget.ImageView

import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.get
import com.liliputdev.decoratorpattern.decorator.IceCream
import com.liliputdev.decoratorpattern.decorator.IceCreamDecorator
import com.liliputdev.decoratorpattern.decorator.IceCreamViewer
import com.liliputdev.decoratorpattern.decorator.iceCreamParts.*
import kotlin.random.Random


/**
 * Created by Masood Dalman on 9/18/2022.
 */
class MainActivityPresenterImpl:MainActivityPresenter {
    private lateinit var context: Context
    private lateinit var view:MainActivityView
    override fun start(activity: Activity,view: MainActivityView) {
        this.context=activity
        this.view=view
    }

    override fun buildView(parts: Array<IceCream>,rootLayout:ConstraintLayout) {
        rootLayout.removeAllViews()
        var listOfDrawables=IceCreamViewer.buildIceCreamResourceList(parts)
        listOfDrawables?.forEachIndexed { index, i ->
            val set = ConstraintSet()

            val view = ImageView(context)
            // adding an ID for imageview, because it is not possible to add ID after add view to parent
            view.id = View.generateViewId()
            view.setImageResource(i)

            val screenWidth=context.resources.displayMetrics.widthPixels
            var divide=2.1
            var width:Int
            val marginBottom: Int
            val targetConnectId: Int
            val targetConnect: Int

            width=(screenWidth/divide).toInt()// width of all ice cream part except the Cone
            when (index) {
                0 -> { // this is cone item
                    divide=2.3
                    marginBottom=0
                    targetConnectId=rootLayout.id
                    targetConnect=ConstraintSet.BOTTOM
                    width=(screenWidth/divide).toInt()// width of the Cone
                }
                1 -> { // this is first scoop
                    marginBottom= -width/3
                    targetConnectId=rootLayout[index-1].id
                    targetConnect=ConstraintSet.TOP
                }
                listOfDrawables.size-1 -> { // this is sprinkles item
                    marginBottom=0
                    targetConnectId=rootLayout[index-1].id
                    targetConnect=ConstraintSet.BOTTOM
                }
                else -> { // these are the rest of scoop
                    marginBottom= (-width/1.5).toInt()
                    targetConnectId=rootLayout[index-1].id
                    targetConnect=ConstraintSet.TOP
                }
            }

            view.layoutParams= ConstraintLayout.LayoutParams(width,width)
            rootLayout.addView(view, index)
            set.clone(rootLayout)// if we don't do this, the connect won't work

            set.connect(view.id, ConstraintSet.START, targetConnectId, ConstraintSet.START, 0)
            set.connect(view.id, ConstraintSet.BOTTOM, targetConnectId, targetConnect, marginBottom)
            set.connect(view.id, ConstraintSet.END, targetConnectId, ConstraintSet.END, 0)

            set.applyTo(rootLayout)
        }
    }

    override fun getPriceAndShowIt(parts: Array<IceCream>) {
        var price=IceCreamViewer.calculateIceCreamPrice(parts)// this function is new, we have to add it to the IceCreamViewer class
        view.showPrice(price)
    }

    override fun getRandomIceCreamPartArray(size: Int, specialCone:Boolean) {
        val iceCream= mutableListOf<IceCream>()
        /* the variable size is going to fill with a seekbar but seekbar in android doesn't have
         MIN_VALUE so we have to add 1 to the size, now our minimum value is always equals to 1*/
        val fixedSize=size+1
            if (specialCone)
                iceCream.add(ConeSpecial())
            else
                iceCream.add(ConeClassic())
            //add random part
            for(i in 1..fixedSize)
            {
                val randomNumber=(0..2).random()
                when(randomNumber)
                {
                    0->iceCream.add(VanillaScoop())
                    1->iceCream.add(StrawberryScoop())
                    2->iceCream.add(ChocolateScoop())
                }
            }
            iceCream.add(Sprinkles())
            view.iceCreamViewReady(iceCream)
    }
}