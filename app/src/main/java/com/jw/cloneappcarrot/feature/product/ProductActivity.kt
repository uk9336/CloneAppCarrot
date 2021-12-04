package com.jw.cloneappcarrot.feature.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.common.Dlog
import com.jw.cloneappcarrot.databinding.ActivityProductBinding
import com.jw.cloneappcarrot.extension.setOnSingleClickListener
import com.jw.cloneappcarrot.model.ProductImageModel
import com.jw.cloneappcarrot.model.ProductInfo
import com.jw.cloneappcarrot.model.json_product
import com.jw.cloneappcarrot.model.json_user
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONException
import org.json.JSONObject

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private val viewModel by viewModels<ProductViewModel>()

    // 이미지 리스트
    private lateinit var imageLists: ArrayList<ProductImageModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        // Set Observer
        observeViewModel()

        // Json Parsing
        getJson()


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
                setProfile(it.userModel.profile_url)
            })
        }
    }


    // Json Parsing
    fun getJson() {
        try {
            val inputStream = assets.open("product_data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val strJson = String(buffer, Charsets.UTF_8)

            val root = JSONObject(strJson)
            val json_product = root.getJSONObject("json_product")
            val json_user = root.getJSONObject("json_user")


            // 이미지 정보 파싱
            imageLists = ArrayList()
            val imageUrl1 = json_product.get("image_url1").toString()
            val imageUrl2 = json_product.get("image_url2").toString()
            val imageUrl3 = json_product.get("image_url3").toString()
            val imageUrl4 = json_product.get("image_url4").toString()
            val imageUrl5 = json_product.get("image_url5").toString()

            if (imageUrl1.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl1))
            if (imageUrl2.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl2))
            if (imageUrl3.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl3))
            if (imageUrl4.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl4))
            if (imageUrl5.isNotEmpty()) imageLists.add(ProductImageModel(imageUrl5))

            // 상품정보 파싱
            val jsonProduct = json_product(
                json_product.get("index").toString(),
                json_product.get("userUid").toString(),
                json_product.get("image_url1").toString(),
                json_product.get("image_url2").toString(),
                json_product.get("image_url3").toString(),
                json_product.get("image_url4").toString(),
                json_product.get("image_url5").toString(),
                json_product.get("title").toString(),
                json_product.get("content").toString(),
                json_product.get("category").toString(),
                json_product.get("chat").toString(),
                json_product.get("like").toString(),
                json_product.get("time").toString(),
                json_product.get("watch").toString(),
            )
            // 유저정보 파싱
            val jsonUser = json_user(
                json_user.get("userUid").toString(),
                json_user.get("nickName").toString(),
                json_user.get("profile_url").toString(),
                json_user.get("neighbor").toString(),
                json_user.get("temp").toString(),
            )


            // 상품 전체 데이터
            val model = ProductInfo(jsonProduct, jsonUser)

            // 데이터 Set
            viewModel.setProduct(model)

        } catch (e: JSONException) {
            Dlog.d("e => $e")
        }
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
            .into(binding.profileIv)
    }
}