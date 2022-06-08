package com.example.smashhere.bottomNavigation

import android.os.Bundle
import android.view.*
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.smashhere.R
import com.example.smashhere.adapters.ViewPagerAdapter
import com.example.smashhere.databinding.FragmentHomeBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Home : Fragment(R.layout.fragment_home) {
//    Initialiser le "TABLAYOUT" et le "VIEWPAGER"
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
//        Programmer la Toolbar
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
//        Appeler le Menu
        toolbar.inflateMenu(R.menu.toolbar_nav)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.notifications -> {
                    true
                }
                else -> false
            }
        }

//      Faire appel à "findViewById" dans un fragment
        viewPager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tabs_home)

//        TABLAYOUT est la structure des Tabs, le VIEWPAGER est l'élément pour
//        swiper les Tabs
        val fragmentAdapter = ViewPagerAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        return view
    }
}