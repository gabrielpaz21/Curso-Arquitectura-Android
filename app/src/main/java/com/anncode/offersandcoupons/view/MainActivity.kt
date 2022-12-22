package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewModel.CouponViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        setUpBindings(savedInstanceState)

    }

    private fun setUpBindings(savedInstanceState: Bundle?) {

        val activityMainBinding:ActivityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponViewModel = ViewModelProviders.of(this)[CouponViewModel::class.java]
        activityMainBinding.model = couponViewModel
        setUpListUpdate()
    }

    private fun setUpListUpdate() {
        couponViewModel?.callCoupons()

        couponViewModel?.getCoupons()?.observe(this) { coupons: List<Coupon> ->
            Log.w("COUPON", coupons[0].title)
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
        }
    }

}
