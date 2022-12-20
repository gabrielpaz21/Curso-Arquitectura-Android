package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.presenter.CouponPresenterImpl


class MainActivity : AppCompatActivity(),CouponView {

    private lateinit var couponPresenter:CouponPresenter

    private lateinit var rvCoupons: RecyclerView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        rvCoupons = binding.rvCoupons
        rvCoupons.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
    }

    override fun getCoupons() {
        couponPresenter.getCoupons()
    }
}
