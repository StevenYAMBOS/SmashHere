package com.example.smashhere

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.smashhere.adapters.ViewPagerAdapter
import com.example.smashhere.bottomNavigation.AdvancedTechniques
import com.example.smashhere.bottomNavigation.Fighters
import com.example.smashhere.bottomNavigation.Home
import com.example.smashhere.bottomNavigation.Settings
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        On initialise la BottomNaviationView dans OnCreate
        val NavigationBarView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

//        Fragments de la BottomNavigationView bar
        val homeFragment = Home()
        val fightersFragment = Fighters()
        val advancedTechniquesFragment = AdvancedTechniques()
        val settingsFragment = Settings()

//        homeFragment comme Fragment principal
        addFragment(homeFragment)

        //BottomNavigationView dans MainActivity avec le fragment "Home" comme fragment principal
        NavigationBarView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> addFragment(homeFragment)
                R.id.fighters -> addFragment(fightersFragment)
                R.id.advancedTechniques -> addFragment(advancedTechniquesFragment)
                R.id.settings -> addFragment(settingsFragment)
            }
            true
        }
    }

//Fonction qui aurait pu s'appeler n'importe comment qui permet d'utiliser
//    supportFragmentManager. Le ChildManager (qui permet d'utiliser des
//    fragments dans d'autres endroits) est dans le fragment Home
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FrameLayout, fragment)
                .commit()
        }

    }

}