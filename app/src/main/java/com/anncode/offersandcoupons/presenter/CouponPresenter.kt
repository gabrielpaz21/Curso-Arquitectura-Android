package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponPresenter {

    //vista
    fun showCoupons(coupons: ArrayList<Coupon>)

    //Interactor
    fun getCoupons()

}