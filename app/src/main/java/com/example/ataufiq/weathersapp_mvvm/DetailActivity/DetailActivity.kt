package com.example.ataufiq.weathersapp_mvvm.DetailActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ataufiq.weathersapp_mvvm.R
import com.example.ataufiq.weathersapp_mvvm.util.obtainViewModel
import com.example.ataufiq.weathersapp_mvvm.util.replaceFragmentInActivity
import com.example.ataufiq.weathersapp_mvvm.util.setupActionBar


class DetailActivity : AppCompatActivity() {

    private lateinit var mActivity: AppCompatActivity
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupToolbar()
        setupFragment()
        mActivity = this
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frameWeather)
        DetailFragment.newInstance(intent.extras).let {
            replaceFragmentInActivity(it, R.id.frameWeather)
        }
    }

    private fun setupToolbar() {
        setupActionBar(R.id.toolbar) {
            setTitle("")
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    }

    fun obtainViewModel(): DetailViewModel = obtainViewModel(DetailViewModel::class.java)

    companion object {

        const val EXTRA_PARCELABLE = "WEATHER_DATA"

    }

}
