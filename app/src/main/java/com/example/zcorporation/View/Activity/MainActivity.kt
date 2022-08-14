package com.example.zcorporation.View.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.zcorporation.R
import com.example.zcorporation.View.Fragment.Fragment_movies
import com.example.zcorporation.View.Fragment.Fragment_tv
import com.example.zcorporation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import me.ibrahimsn.lib.OnItemReselectedListener
import me.ibrahimsn.lib.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            val fragment = Fragment_movies()
            move_to_fragment(fragment)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //navController = findNavController(R.id.main_fragment)
        // setupActionBarWithNavController(navController)
        //setupSmoothBottomMenu()

        binding.bottomNav.onItemSelected = {
            //status.text = "Item $it selected"
            var fragment: Fragment? = null
            if (it == 0) {
                //showToast("movies")
                fragment = Fragment_movies()

            } else if (it == 1) {
                fragment = Fragment_tv()
            }

            if (fragment != null) {
                move_to_fragment(fragment)
            }
        }

        binding.bottomNav.onItemReselected = {
            val msg = "You are on the current page"

            showToast(msg)
        }
    }

    private fun move_to_fragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }



    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}