package internship.gits.weatherapps.util

import android.content.Context
import android.preference.PreferenceManager
import internship.gits.weatherapps.data.source.NewsRepository
import internship.gits.weatherapps.data.source.local.NewsLocalDataSource
import internship.gits.weatherapps.data.source.remote.NewsRemoteDataSource

object Injection{
    fun provideNewsRepository(context: Context) = NewsRepository.getInstance(NewsRemoteDataSource,
            NewsLocalDataSource.getInstance(PreferenceManager.getDefaultSharedPreferences(context))!!)
}