package com.jw.cloneappcarrot.feature.splash

import android.os.Bundle
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseActivity
import com.jw.cloneappcarrot.databinding.ActivityStartBinding

class StartActivity : BaseActivity<ActivityStartBinding, StartViewModel>(
    R.layout.activity_start
) {

    override fun defineViewModel() = getViewModel(StartViewModel::class.java)

    override fun onCreated(savedInstanceState: Bundle?) {
    }

}