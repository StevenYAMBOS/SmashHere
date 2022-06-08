package com.example.smashhere.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smashhere.InTournamentFragment
import com.example.smashhere.NewcomersFragment
import com.example.smashhere.VeteransFragment
import com.example.smashhere.bottomNavigation.AdvancedTechniques
import com.example.smashhere.bottomNavigation.Home

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
//        "Return 3" car on a 3 TABS
        return 3
    }

    //    Fragments des TABs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                NewcomersFragment()
            }
            1 -> {
                VeteransFragment()
            }
            2 -> {
                InTournamentFragment()
            }
            else -> {
                InTournamentFragment()
            }
        }
    }


    //    Nom des TABS
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Newcomers"
            1 -> "Veterans"
            else -> {
                return "In Tournament"
            }
        }
    }
}