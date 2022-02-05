package com.example.smashhere.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smashhere.Fragments.InTournamentFragment
import com.example.smashhere.Fragments.NewComersFragment
import com.example.smashhere.Fragments.VeteransFragment

class ViewPagerAdapter (fragmentManager: FragmentManager,lifecycle:Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
//        "return 3" car on a 3 fragments
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                NewComersFragment()
            }
            1->{
                VeteransFragment()
            }
            2->{
                InTournamentFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}