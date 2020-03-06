package com.godeliveryservices.shop.models

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

data class Order(
    val Amount: Double,
    val RiderName: String,
    val CustomerAddress: String,
    val CustomerName: String,
    val CustomerNumber: String,
    val DeliveredDate: Any,
    val DeliveredTime: Any,
    val DeliveryDate: String,
    val DeliveryTime: String,
    val Distance: Double,
    val Instructions: String,
    val OrderDate: String,
    val OrderDetails: String,
    val OrderID: Int,
    val OrderTime: String,
    val PickUpDate: Any,
    val PickUpTime: Any,
    val Rider: Rider?,
    val RiderID: Any,
    val ShopBranch: Branch?,
    val ShopBranchID: Int,
    val Status: String,
    val Cash: String
) {
    val orderDateFormatted: String?
        get() {
            val inputPattern = "dd-MMM-yyyy"
            val outputPattern = "dd'\n'MMM"
            val inputFormat = SimpleDateFormat(inputPattern, Locale.US)
            val outputFormat = SimpleDateFormat(outputPattern, Locale.US)

            var date: Date? = null
            var str: String? = null

            try {
                date = inputFormat.parse(OrderDate)
                str = outputFormat.format(date ?: return null)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return str
        }
}