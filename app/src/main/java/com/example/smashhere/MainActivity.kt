package com.example.smashhere

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.smashhere.Extensions.toast
import com.example.smashhere.adapters.ViewPagerAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {

    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ajouter "androidx.appcompat.widget.Toolbar" dans Import pour que la PUTAIN de ToolBar fonctionne
        //Appeler la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2: ViewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Newcomers"
                }
                1 -> {
                    tab.text = "Veterans"
                }
                2 -> {
                    tab.text = "In tournament"
                }
            }
        }.attach()

    }
    //Créer les actions de la barre d’action
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_nav, menu)
        return true
    }

    //Connecter les icônes qu'on a appeler en créant le menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notifications
            -> true
        }
        return super.onOptionsItemSelected(item)
    }

    //Log Out (A CREER)
}