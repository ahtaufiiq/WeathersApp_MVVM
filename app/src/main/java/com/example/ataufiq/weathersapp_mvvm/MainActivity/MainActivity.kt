package com.example.ataufiq.weathersapp_mvvm.MainActivity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ataufiq.weathersapp_mvvm.R
import internship.gits.weatherapps.data.News
import internship.gits.weatherapps.news.MainFragment
import internship.gits.weatherapps.news.MainViewModel
import internship.gits.weatherapps.news.WeathersItemUserActionListener
import internship.gits.weatherapps.newsdetail.DetailActivity
import internship.gits.weatherapps.util.obtainViewModel
import internship.gits.weatherapps.util.replaceFragmentInActivity
import internship.gits.weatherapps.util.setupActionBar

class MainActivity : AppCompatActivity(), WeathersItemUserActionListener {

    private lateinit var mActivity: AppCompatActivity
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_act)

        setupToolbar()
        setupFragment()
        setupViewModel()
        mActivity = this
    }



    private fun setupViewModel() {
        viewModel = obtainViewModel().apply{
            openDetailNews.observe(this@MainActivity, Observer{ news ->
                onNewsClicked(news!!)
            })
        }
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frameNews)
        MainFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.frameNews)
        }
    }

    private fun setupToolbar() {
        setupActionBar(R.id.toolbar){
            title = "NewsApp"
        }
    }

    override fun onNewsClicked(news : News){
        val bundle = Bundle()
        bundle.putParcelable(DetailActivity.EXTRA_PARCELABLE,news)
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtras(bundle)
        }
        startActivity(intent)

    }

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)


}
