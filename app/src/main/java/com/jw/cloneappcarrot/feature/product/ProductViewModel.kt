package com.jw.cloneappcarrot.feature.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jw.cloneappcarrot.model.JsonProduct
import com.jw.cloneappcarrot.model.ProductInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@HiltViewModel
class ProductViewModel @Inject constructor() : ViewModel() {

    /**
     * 상품 정보
     */
    val _product = MutableLiveData<JsonProduct>()
    val product: LiveData<JsonProduct>
        get() = _product

    fun setProduct(info: JsonProduct) {
        _product.value = info
    }
}