package com.example.ataufiq.weathersapp_mvvm.MainActivity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.ataufiq.weathersapp_mvvm.R
import com.example.ataufiq.weathersapp_mvvm.data.Weather
import com.example.ataufiq.weathersapp_mvvm.DetailActivity.DetailActivity
import com.example.ataufiq.weathersapp_mvvm.util.obtainViewModel
import com.example.ataufiq.weathersapp_mvvm.util.replaceFragmentInActivity
import com.example.ataufiq.weathersapp_mvvm.util.setupActionBar

class MainActivity : AppCompatActivity(), WeathersItemUserActionListener {

    private lateinit var mActivity: AppCompatActivity
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Start Result","Start")
        setupFragment()
        setupViewModel()
        mActivity = this
    }



    private fun setupViewModel() {
        viewModel = obtainViewModel().apply{
            openDetailWeather.observe(this@MainActivity, Observer{ weather ->
                onWeatherClicked(weather!!)
            })
        }
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frameWeather)
        MainFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.frameWeather)
        }
    }

    override fun onWeatherClicked(weather : Weather){
        val bundle = Bundle()
        bundle.putParcelable(DetailActivity.EXTRA_PARCELABLE,weather)
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtras(bundle)
        }
        startActivity(intent)

    }

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)


}
