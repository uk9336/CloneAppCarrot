package com.jw.cloneappcarrot.feature.product

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseActivity
import com.jw.cloneappcarrot.common.Dlog
import com.jw.cloneappcarrot.databinding.ActivityProductBinding
import com.jw.cloneappcarrot.extension.setOnSingleClickListener
import com.jw.cloneappcarrot.model.JsonProduct
import com.jw.cloneappcarrot.model.ProductImageModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : BaseActivity<ActivityProductBinding, ProductViewModel>(
    R.layout.activity_product
) {

    override val viewModel by viewModels<ProductViewModel>()

    // 이미지 리스트
    private lateinit var imageLists: ArrayList<ProductImageModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set Observer
        observeViewModel()

        // Get Data
        getData()

        // 뒤로가기
        binding.backIv.setOnSingleClickListener { onBackPressed() }
    }

    // Set Observer
    fun observeViewModel() {

        viewModel.apply {
            product.observe(this@ProductActivity, Observer {
                Dlog.d("it => $it")
                // 뷰페이저 등록
                setViewPager()

                // 프로필 사진
                setProfile(it.json_user.profile_url)
            })
        }
    }

    // 받아온 데이터
    fun getData() {
        val info = intent.getSerializableExtra("info")
        viewModel.setProduct(info as JsonProduct)

        // 이미지 정보 파싱
        imageLists = ArrayList()
        val imageUrl1 = info.image_url1
        val imageUrl2 = info.image_url2
        val imageUrl3 = info.image_url3
        val imageUrl4 = info.image_url4
        val imageUrl5 = info.image_url5

        if (imageUrl1.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl1))
        if (imageUrl2.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl2))
        if (imageUrl3.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl3))
        if (imageUrl4.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl4))
        if (imageUrl5.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl5))
    }

    // 뷰페이저 등록
    fun setViewPager() {
        binding.viewPager.apply {
            this.adapter = ProductAdapter(imageLists, this@ProductActivity)
            binding.dotsIndicator.setViewPager2(this)
        }

    }

    // 프로필 이미지 설정
    fun setProfile(url: String) {

        // 프로필 이미지 원형으로 만들기
        binding.profileIv.clipToOutline = true

        // 프로필 이미지
        Glide.with(this@ProductActivity)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.profileIv)
    }
}