package com.hoangnv.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.appsmartnote2024.R
import com.example.appsmartnote2024.base.BaseBindingActivity
import com.example.appsmartnote2024.databinding.ActivityMainBinding


class MainActivity : BaseBindingActivity<ActivityMainBinding, MainViewModel>() {
    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
    val navController: NavController by lazy { navHostFragment.navController }
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun setupData() {
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }
}