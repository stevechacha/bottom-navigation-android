package com.steve.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navVieww: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val homeFragment=HomeFragment()
        val searchFragment=SearchFragment()
        val notificationFragment=NotificationFragment()
        val messageFragment=MessageFragment()

        setCurrentFragment(homeFragment)
        navVieww.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home ->setCurrentFragment(homeFragment)
                R.id.search ->setCurrentFragment(searchFragment)
                R.id.notification ->setCurrentFragment(notificationFragment)
                R.id.message ->setCurrentFragment(messageFragment)
            }
            true
        }
        navVieww.getOrCreateBadge(R.id.message).apply {
            number=10
            isVisible=true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.buttomFragment,fragment)
            commit()
        }
}
