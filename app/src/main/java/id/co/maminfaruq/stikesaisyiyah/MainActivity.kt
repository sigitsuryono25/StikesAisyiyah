package id.co.maminfaruq.stikesaisyiyah

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import id.co.maminfaruq.stikesaisyiyah.R.id.message
import id.co.maminfaruq.stikesaisyiyah.ui.maps.MapsFragment
import id.co.maminfaruq.stikesaisyiyah.ui.menu.MenuFragment
import id.co.maminfaruq.stikesaisyiyah.ui.telephone.TelephoneFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mHome = MenuFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, mHome)
                .commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val fragment = MenuFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, fragment, fragment.javaClass.simpleName)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val maps = MapsFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, maps, maps.javaClass.simpleName)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val telp = TelephoneFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, telp, telp.javaClass.simpleName)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
