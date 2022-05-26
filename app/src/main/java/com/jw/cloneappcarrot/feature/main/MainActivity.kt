package com.jw.cloneappcarrot.feature.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import com.google.android.material.navigation.NavigationBarView
import com.jw.cloneappcarrot.R
import com.jw.cloneappcarrot.base.BaseActivity
import com.jw.cloneappcarrot.databinding.ActivityMainBinding
import com.jw.cloneappcarrot.extension.fadeVisibility
import com.jw.cloneappcarrot.extension.setOnSingleClickListener
import com.jw.cloneappcarrot.feature.tab_chat.ChatFragment
import com.jw.cloneappcarrot.feature.tab_home.HomeFragment
import com.jw.cloneappcarrot.feature.tab_map.MapFragment
import com.jw.cloneappcarrot.feature.tab_mypage.MyPageFragment
import com.jw.cloneappcarrot.feature.tab_neighbor.NeighborFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
), NavigationBarView.OnItemSelectedListener {

    override fun defineViewModel() = getViewModel(MainViewModel::class.java)

    private lateinit var fabOpenAnim: Animation
    private lateinit var fabCloseAnim: Animation
    private lateinit var rotateClock: Animation
    private lateinit var rotateAntiClock: Animation
    private lateinit var alphaOnAnim: Animation
    private lateinit var alphaOffAnim: Animation

    override fun onCreated(savedInstanceState: Bundle?) {

        // Bottom Navigation Listener
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.frameLayout, HomeFragment()).commit()
        }
        binding.bottomNavi.setOnItemSelectedListener(this)

        // init
        init()

        // Set Observer
        observeViewModel()

        binding.dimensionView.setOnSingleClickListener {
            viewModel._fabOpen.value = false
        }
        binding.fab1.setOnSingleClickListener {
            if (viewModel.fabOpen.value == null)
                viewModel._fabOpen.value = true
            else viewModel._fabOpen.value = !viewModel.fabOpen.value!!
        }
    }

    // init
    fun init() {
        // Animation
        fabOpenAnim = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fabCloseAnim = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        rotateClock = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
        rotateAntiClock = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlockwise)
        alphaOnAnim = AlphaAnimation(0f, 1f)
        alphaOffAnim = AlphaAnimation(1f, 0f)
        alphaOnAnim.duration = 300
        alphaOffAnim.duration = 300
    }

    // Set Observer
    fun observeViewModel() {

        viewModel.apply {

            // 플로팅 버튼
            fabOpen.observe(this@MainActivity, Observer {
                // 열기
                if (it) {
                    binding.fab2.startAnimation(fabOpenAnim)
                    binding.fab3.startAnimation(fabOpenAnim)
                    binding.fab1.startAnimation(rotateAntiClock)
                    binding.dimensionView.fadeVisibility(View.VISIBLE, 400)
                    binding.fab2Tv.visibility = View.VISIBLE
                    binding.fab3Tv.visibility = View.VISIBLE
                }
                // 닫기
                else {
                    binding.fab2.startAnimation(fabCloseAnim)
                    binding.fab3.startAnimation(fabCloseAnim)
                    binding.fab1.startAnimation(rotateClock)
                    binding.dimensionView.fadeVisibility(View.GONE, 400)
                    binding.fab2Tv.visibility = View.GONE
                    binding.fab3Tv.visibility = View.GONE
                }
            })
        }
    }

    // Bottom Navigation Item Selected
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.page1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment())
                    .commitAllowingStateLoss()
                binding.fab1.visibility = View.VISIBLE
                true
            }
            R.id.page2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, NeighborFragment())
                    .commitAllowingStateLoss()
                binding.fab1.visibility = View.GONE
                true
            }
            R.id.page3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MapFragment())
                    .commitAllowingStateLoss()
                binding.fab1.visibility = View.GONE
                true
            }
            R.id.page4 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, ChatFragment())
                    .commitAllowingStateLoss()
                binding.fab1.visibility = View.GONE
                true
            }
            R.id.page5 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, MyPageFragment())
                    .commitAllowingStateLoss()
                binding.fab1.visibility = View.GONE
                true
            }
            else -> false
        }
    }
}