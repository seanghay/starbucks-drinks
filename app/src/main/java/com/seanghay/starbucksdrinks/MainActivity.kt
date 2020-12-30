package com.seanghay.starbucksdrinks

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.airbnb.epoxy.Carousel
import com.seanghay.starbucksdrinks.databinding.ActivityMainBinding
import com.seanghay.starbucksdrinks.fragment.MenuFragment
import com.seanghay.starbucksdrinks.fragment.RecommendedFragment

class MainActivity : StarbucksActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Carousel.setDefaultGlobalSnapHelperFactory(object : Carousel.SnapHelperFactory() {
            override fun buildSnapHelper(context: Context?): SnapHelper {
                return PagerSnapHelper()
            }
        })

        replaceFragmentOfTag("recommended") { RecommendedFragment.newInstance() }

        binding.bottomNav.setOnNavigationItemSelectedListener(::handleItemSelection)
    }

    private fun <T : Fragment> replaceFragmentOfTag(tag: String, factory: () -> T) {
        val primaryFragment = findFragmentByTagOrElse(tag, factory)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, primaryFragment, tag)
            setPrimaryNavigationFragment(primaryFragment)
        }
    }

    private fun handleItemSelection(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item_menu) {
            replaceFragmentOfTag("menu") { MenuFragment.newInstance() }
            return true
        }
        if (item.itemId == R.id.menu_item_recommended) {
            replaceFragmentOfTag("recommended") { RecommendedFragment.newInstance() }
            return true
        }
        return false
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : Fragment> findFragmentByTagOrElse(tag: String, factory: () -> T): T {
        return supportFragmentManager.findFragmentByTag(tag) as? T ?: factory()
    }

}