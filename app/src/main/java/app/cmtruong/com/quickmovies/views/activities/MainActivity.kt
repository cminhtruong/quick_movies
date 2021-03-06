package app.cmtruong.com.quickmovies.views.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import app.cmtruong.com.quickmovies.R
import app.cmtruong.com.quickmovies.views.fragments.FavoriteFragment
import app.cmtruong.com.quickmovies.views.fragments.PopularFragment
import app.cmtruong.com.quickmovies.views.fragments.TopRatedFragment
import app.cmtruong.com.quickmovies.views.fragments.TrendingFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

/**
 * @author Davide Truong
 * @version 1.0
 * @since October 25th, 2018
 */
class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        val TAG = MainActivity::class.java.canonicalName as String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("$TAG is created")

        // Setup toolbar
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            populateUI()
        }
    }

    private fun populateUI(){
        supportFragmentManager
                .beginTransaction()
                .add(R.id.trending_container, TrendingFragment.getInstance(), "trending")
                .addToBackStack(null)
                .commit()

        supportFragmentManager
                .beginTransaction()
                .add(R.id.popular_container, PopularFragment.getInstance())
                .addToBackStack(null)
                .commit()

        supportFragmentManager
                .beginTransaction()
                .add(R.id.top_rate_container, TopRatedFragment.getInstance())
                .addToBackStack(null)
                .commit()

        favorite_container.visibility = View.GONE
/*
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.favorite_container, FavoriteFragment.getInstance())
                    .addToBackStack(null)
                    .commit()
*/
    }
}
