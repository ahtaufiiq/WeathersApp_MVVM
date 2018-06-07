package internship.gits.weatherapps.newsdetail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import internship.gits.weatherapps.data.News
import internship.gits.weatherapps.data.source.NewsRepository
import internship.gits.weatherapps.util.SingleLiveEvent

class DetailViewModel(application: Application, newsRepository: NewsRepository) : AndroidViewModel(application){
    val details: ObservableField<News> = ObservableField()
    internal val openBrowser = SingleLiveEvent<String>()

    fun start(){

    }

    fun loadWeb() {
        openBrowser.value = details.get()?.url
    }


}