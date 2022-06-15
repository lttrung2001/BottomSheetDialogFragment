package com.ltbth.bottomsheetdialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ltbth.bottomsheetdialogfragment.model.MyBottomSheetDialogFragment
import com.ltbth.bottomsheetdialogfragment.model.Order
import com.ltbth.bottomsheetdialogfragment.model.Product
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.open_bottom_sheet)
        button.setOnClickListener {
            val products = arrayListOf<Product>()
            for (i in 1..4) {
                products.add(Product("Product $i x${Random.nextInt()}"))
            }
            val order = Order("1 tỷ",products,"Biên Hòa, Đồng Nai")
            val myBottomSheetDialogFragment = MyBottomSheetDialogFragment.newInstance(order)
            myBottomSheetDialogFragment.isCancelable = false
            myBottomSheetDialogFragment.show(supportFragmentManager,myBottomSheetDialogFragment.tag)
        }
    }
}