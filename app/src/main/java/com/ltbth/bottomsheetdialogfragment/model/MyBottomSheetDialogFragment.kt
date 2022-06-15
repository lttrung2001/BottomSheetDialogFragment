package com.ltbth.bottomsheetdialogfragment.model

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ltbth.bottomsheetdialogfragment.R

class MyBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private lateinit var order: Order
    lateinit var tvPrice: TextView
    lateinit var tvProductName: TextView
    lateinit var tvAddress: TextView
    lateinit var buttonCancel: TextView
    companion object {
        private const val KEY_ORDER_OBJECT = "order_object"

        fun newInstance(order: Order): MyBottomSheetDialogFragment {
            val myBottomSheetDialogFragment = MyBottomSheetDialogFragment()
            val bundle = Bundle()
            bundle.putSerializable(KEY_ORDER_OBJECT,order)
            myBottomSheetDialogFragment.arguments = bundle
            return myBottomSheetDialogFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        order = bundle?.get(KEY_ORDER_OBJECT) as Order
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_fragment,null)
        bottomSheetDialog.setContentView(view)
        initView(view)
        setOrderData()
        buttonCancel.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
        return bottomSheetDialog
    }

    private fun initView(view: View) {
        tvPrice = view.findViewById(R.id.tv_price)
        tvProductName = view.findViewById(R.id.tv_product_name)
        tvAddress = view.findViewById(R.id.tv_address)
        buttonCancel = view.findViewById(R.id.btn_cancel)
    }

    private fun setOrderData() : String {
        tvPrice.text = order.price
        tvAddress.text = order.address
        order.let {
            var str: String = ""
            for (item in order.products) {
                str += item.name + "\n"
            }
            tvProductName.text = str
        }
        return tvProductName.text.toString()
    }
}