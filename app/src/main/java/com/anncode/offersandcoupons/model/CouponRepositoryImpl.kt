package com.anncode.offersandcoupons.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CouponRepositoryImpl : CouponRepository {

    private var coupons = MutableLiveData<List<Coupon>>()

    override fun getCoupons() : MutableLiveData<List<Coupon>> =  coupons

    override fun callCouponsApi() {

        val couponsList: ArrayList<Coupon> = ArrayList()
        val apiService = ApiAdapter().getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message.toString())
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                if (response.body()!!.get("offers").isJsonNull) {
                    //Toast.makeText(this, "Error connecting to the service", Toast.LENGTH_SHORT).show()
                    return
                }

                val offersJsonArray = response.body()?.getAsJsonArray("offers")

                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Coupon(jsonObject)
                    couponsList.add(coupon)
                }
                coupons.value = couponsList
            }

        })
    }

}