package com.anncode.offersandcoupons.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.databinding.ActivityCouponDetailBinding
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCouponDetailBinding

    private var couponSelected: Coupon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCouponDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        couponSelected = intent.getSerializableExtra("COUPON") as Coupon

        val tvTitleDetail: TextView = binding.tvTitleDetail
        val tvDescriptionShortDetail: TextView = binding.tvDescriptionShortDetail
        val tvCategoryDetail: TextView = binding.tvCategoryDetail
        val tvDateDetail: TextView = binding.tvDateDetail
        val tvDescriptionDetailData: TextView = binding.tvDescriptionDetailData
        val tvOfferDetailData: TextView = binding.tvOffertDetailData
        val tvWebsiteDetailData: TextView = binding.tvWebsiteDetailData
        val tvDateEndData: TextView = binding.tvDateEndData
        val imgHeaderDetail: ImageView = binding.imgHeaderDetail
        val imgCouponDetail: CircleImageView = binding.imgCouponDetail
        val btnOpenOffer: Button = binding.btnOpenOffer

        tvTitleDetail.text = couponSelected?.title
        tvDescriptionShortDetail.text = couponSelected?.descriptionShort
        tvCategoryDetail.text = couponSelected?.category
        tvDateDetail.text = couponSelected?.endDate
        tvDescriptionDetailData.text = couponSelected?.description
        tvOfferDetailData.text = couponSelected?.offer
        tvWebsiteDetailData.text = couponSelected?.website
        tvDateEndData.text = couponSelected?.endDate

        Picasso.get().load(couponSelected?.imageUrl).resize(520, 520).centerCrop().into(imgHeaderDetail)
        Picasso.get().load(couponSelected?.imageUrl).resize(520, 520).centerCrop().into(imgCouponDetail)

        btnOpenOffer.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(couponSelected?.url)
            startActivity(openURL)
        }
    }
}
