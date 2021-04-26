package com.room.roomsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.room.roomsqlite.ui.fragment.KelasFragment
import com.room.roomsqlite.ui.fragment.SiswaFragment

class MainActivity : AppCompatActivity() {
    private lateinit var menu : Menu
    private lateinit var menuItem : MenuItem
    private lateinit var buttonNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomNav()
        callFragment(0, KelasFragment())
    }
    private fun setUpBottomNav(){
        buttonNavigationView = findViewById(R.id.nav_view)
        menu = buttonNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        buttonNavigationView.setOnNavigationItemReselectedListener { item->
            when(item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0, KelasFragment())
                }
                R.id.navigation_dashboard -> {
                    callFragment(1, SiswaFragment())
                }
            }

            false
        }
    }
    private  fun callFragment(int: Int, fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        callFragment(fragment)
    }
    private fun callFragment(f: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, f)
            .commit()
    }

}