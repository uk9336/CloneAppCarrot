package com.jw.cloneappcarrot.feature.main

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseActivity
import com.jw.cloneappcarrot.databinding.ActivityMainBinding
import com.jw.cloneappcarrot.feature.tab_chat.ChatFragment
import com.jw.cloneappcarrot.feature.tab_home.HomeFragment
import com.jw.cloneappcarrot.feature.tab_map.MapFragment
import com.jw.cloneappcarrot.feature.tab_mypage.MyPageFragment
import com.jw.cloneappcarrot.feature.tab_neighbor.NeighborFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main),
    NavigationBarView.OnItemSelectedListener {

    override val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Bottom Navigation Listener
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.frameLayout, HomeFragment()).commit()
        }
        binding.bottomNavi.setOnItemSelectedListener(this)

        // Set Observer
        observeViewModel()
    }

    // Set Observer
    fun observeViewModel() {

        viewModel.apply {

        }
    }

    // Bottom Navigation Item Selected
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.page1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment())
                    .commitAllowingStateLoss()
                true
            }
            R.id.page2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, NeighborFragment())
                    .commitAllowingStateLoss()
                true
            }
            R.id.page3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MapFragment())
                    .commitAllowingStateLoss()
                true
            }
            R.id.page4 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, ChatFragment())
                    .commitAllowingStateLoss()
                true
            }
            R.id.page5 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, MyPageFragment())
                    .commitAllowingStateLoss()
                true
            }
            else -> false
        }
    }
}