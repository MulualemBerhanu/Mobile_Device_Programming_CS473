package com.inifiny.walmart

import java.io.Serializable

data class Product(val name:String,val price:String,val color:String,val image:Int,val description:String):Serializable {
}