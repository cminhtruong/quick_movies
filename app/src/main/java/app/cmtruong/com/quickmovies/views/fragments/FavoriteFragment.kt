package app.cmtruong.com.quickmovies.views.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.cmtruong.com.quickmovies.R
import app.cmtruong.com.quickmovies.adapters.MoviesAdapter
import app.cmtruong.com.quickmovies.models.Movies
import app.cmtruong.com.quickmovies.views.activities.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_favorite.*
import timber.log.Timber

/**
 * @author davidetruong
 * @version 1.0
 * @since 2018 November 19th
 */
class FavoriteFragment: Fragment() {

    companion object {
        @JvmStatic
        private val TAG = FavoriteFragment::class.java.canonicalName

        fun getInstance(): FavoriteFragment = FavoriteFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("$TAG is created ...")
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

     private fun showMessageError() {
        pb_movie.visibility = View.GONE
        movie_error.visibility = View.VISIBLE
        rv_movies.visibility = View.GONE
    }

    private fun showResults(){
        pb_movie.visibility = View.GONE
        movie_error.visibility = View.GONE
        rv_movies.visibility = View.VISIBLE
    }

    private fun loadingData(){
        pb_movie.visibility = View.VISIBLE
        movie_error.visibility = View.GONE
        rv_movies.visibility = View.GONE
    }

    private fun RecyclerView.setupData(movies: List<Movies>) {
        this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        this.setHasFixedSize(true)
        this.adapter = MoviesAdapter(movies){
            val intent = Intent(activity, MovieDetailActivity::class.java).apply {
                putExtra(getString(R.string.movie_list), ArrayList(movies))
                putExtra(getString(R.string.movie_position), movies.indexOf(it))
            }
            startActivity(intent)
        }
        showResults()
    }
}