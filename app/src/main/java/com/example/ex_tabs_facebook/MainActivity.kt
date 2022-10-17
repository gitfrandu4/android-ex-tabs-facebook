package com.example.ex_tabs_facebook

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.ex_tabs_facebook.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        title = ""

        val myViewPager2: ViewPager2 = binding.viewpager2
        val myTabLayout: TabLayout = binding.tablayout

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return 5
            }

            // Aquí es donde abriremos un fragment cuando se pulse en uno de los tabs
            override fun createFragment(position: Int): Fragment {
                if (position == 0) {
                    return HomeFragment()
                }

                if (position == 1) {
                    return PlayFragment()
                }

                if (position == 2) {
                    return GroupFragment()
                }

                if (position == 3) {
                    return Notifications()
                }

                return MenuFragment()
            }

        }
        myViewPager2.adapter = adapter

        TabLayoutMediator(myTabLayout, myViewPager2) { tab, position ->
            when (position) {
                0 -> {
                    // tab.text = "Home"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_home_24)
                    tab.icon?.setTint(Color.parseColor("#686868"))
                }

                1 -> {
                    // tab.text = "Play"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_smart_display_24)
                    tab.icon?.setTint(Color.parseColor("#686868"))
                }

                2 -> {
                    // tab.text = "Group"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_groups_24)
                    tab.icon?.setTint(Color.parseColor("#686868"))
                }

                3 -> {
                    // tab.text = "Notifications"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_notifications_24)
                    tab.icon?.setTint(Color.parseColor("#686868"))

                    // Get badge from tab (or create one if none exists)
                    val badge = tab.getOrCreateBadge()
                    // Customize badge
                    badge.number = 2
                    // Remove badge from tab
                }
                4 -> {
                    // tab.text = "Menu"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_menu_24)
                    tab.icon?.setTint(Color.parseColor("#686868"))
//                    tab.icon?.setTint(Color.parseColor("#4267B2"))
                }
            }
        }.attach()

        myTabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon!!.setTint(Color.parseColor("#4267B2"))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon!!.setTint(Color.parseColor("#686868"))
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                tab.icon!!.setTint(Color.parseColor("#4267B2"))
            }
        })

        myTabLayout.getTabAt(0)!!.select()
    }
}