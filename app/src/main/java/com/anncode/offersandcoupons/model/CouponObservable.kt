package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable : BaseObservable() {

    private var couponRepository:CouponRepository = CouponRepositoryImpl()

    //Repository
    fun callCoupons(){
        couponRepository.callCouponsApi()
    }

    //ViewModel
    fun getCoupons() : MutableLiveData<List<Coupon>> = couponRepository.getCoupons()

}