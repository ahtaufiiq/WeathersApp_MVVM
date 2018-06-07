package internship.gits.weatherapps.util

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting
import internship.gits.weatherapps.data.source.NewsRepository
import internship.gits.weatherapps.news.MainViewModel
import internship.gits.weatherapps.newsdetail.DetailViewModel

class ViewModelFactory private constructor(
        private val application: Application,
        private val newsRepository: NewsRepository
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>)= with(modelClass) {
        when{
            isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(application,newsRepository)
            isAssignableFrom(DetailViewModel::class.java) ->
                    DetailViewModel(application,newsRepository)
            else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }as T

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE
                        ?: synchronized(ViewModelFactory::class.java){
                    INSTANCE
                            ?: ViewModelFactory(
                                    application, Injection.provideNewsRepository(application.applicationContext))
                            .also { INSTANCE = it }
                }

        @VisibleForTesting fun destroyInstance(){
            INSTANCE = null
        }
    }
}