package com.example.smashhere

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.core.view.updateLayoutParams
import com.google.android.material.appbar.AppBarLayout


class Characters : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        //Bouton retour
        setSupportActionBar(findViewById(R.id.characters_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.characters_toolbar)
        toolbar.updateLayoutParams<AppBarLayout.LayoutParams> {
            var scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
        }
    }

    //Toolbar personnages
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search
            -> true
        }
        return super.onOptionsItemSelected(item)
    }
}




