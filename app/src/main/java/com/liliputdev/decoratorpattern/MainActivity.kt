package com.liliputdev.decoratorpattern

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.core.view.marginBottom
import com.liliputdev.decoratorpattern.decorator.IceCream
import com.liliputdev.decoratorpattern.decorator.IceCreamViewer
import com.liliputdev.decoratorpattern.decorator.iceCreamParts.*

class MainActivity : AppCompatActivity(),MainActivityView, SeekBar.OnSeekBarChangeListener,
    CompoundButton.OnCheckedChangeListener {
    lateinit var root: ConstraintLayout
    lateinit var seekBar: SeekBar
    lateinit var checkboxSpecialCone:CheckBox
    lateinit var textviewPrice:TextView
    var PROGRESS=1
    var SPECIAL=false
    var presenter=MainActivityPresenterImpl()// very important
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // find all views
        root=findViewById(R.id.root)
        seekBar=findViewById(R.id.seekbar)
        checkboxSpecialCone=findViewById(R.id.checkBoxSpecial)
        textviewPrice=findViewById(R.id.textviewPrice)
        seekBar.setOnSeekBarChangeListener(this)
        checkboxSpecialCone.setOnCheckedChangeListener(this)

        presenter.start(this, this)// don't forget to initialize the presenter
        // we call it to have something to show to the user at the beginning
        presenter.getRandomIceCreamPartArray(PROGRESS,SPECIAL)
    }

    override fun iceCreamViewReady(iceCream: MutableList<IceCream>) {
        presenter.buildView(iceCream.toTypedArray(),root)
        presenter.getPriceAndShowIt(iceCream.toTypedArray())
    }

    override fun showPrice(price: String?) {
        textviewPrice.text="price: $price$"
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        PROGRESS=progress
        presenter.getRandomIceCreamPartArray(PROGRESS,SPECIAL)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        SPECIAL=isChecked
        presenter.getRandomIceCreamPartArray(PROGRESS,SPECIAL)
    }
}
