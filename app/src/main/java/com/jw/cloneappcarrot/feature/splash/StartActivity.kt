package com.jw.cloneappcarrot.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jw.cloneappcarrot.feature.main.MainActivity
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.databinding.ActivityStartBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            overridePendingTransition(0,0)
        }
    }
}