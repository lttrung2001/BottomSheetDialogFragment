package com.ltbth.bottomsheetdialogfragment.model

import java.io.Serializable

class Order(var price: String,var products: List<Product>, var address: String) : Serializable {

}