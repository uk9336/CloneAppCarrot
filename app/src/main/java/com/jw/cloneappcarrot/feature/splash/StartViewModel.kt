package com.jw.cloneappcarrot.feature.splash

import android.content.Intent
import androidx.lifecycle.viewModelScope
import com.jw.cloneappcarrot.base.BaseViewModel
import com.jw.cloneappcarrot.feature.Command
import com.jw.cloneappcarrot.feature.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by LJW on 2022/01/11.
 *
 * Description :
 */
class StartViewModel : BaseViewModel() {

    override fun onInitInternal() {
        viewModelScope.launch {
            delay(1000)
            startActivity(Intent(activity, MainActivity::class.java))
            activity.overridePendingTransition(0, 0)
            finish()
        }
    }

    override fun onHandleEvent(event: Command) {}
}
