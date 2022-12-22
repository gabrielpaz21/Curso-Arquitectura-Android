package com.anncode.offersandcoupons.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter

class CouponViewModel : ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()

    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupons() {
        couponObservable.callCoupons()
    }

    fun getCoupons(): MutableLiveData<List<Coupon>> = couponObservable.getCoupons()

    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>) {
        recyclerCouponsAdapter?.setCouponList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter =
        RecyclerCouponsAdapter(this, R.layout.card_coupon)

    fun getCouponAt(position: Int): Coupon? = getCoupons().value?.get(position)

}