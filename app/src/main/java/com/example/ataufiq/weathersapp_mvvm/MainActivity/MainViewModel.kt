package internship.gits.weatherapps.news

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.widget.Toast
import internship.gits.weatherapps.data.News
import internship.gits.weatherapps.data.source.NewsDataSource
import internship.gits.weatherapps.data.source.NewsRepository
import internship.gits.weatherapps.util.SingleLiveEvent

class MainViewModel(application: Application, private val newsRepository: NewsRepository) : AndroidViewModel(application){
    val newsList: ObservableList<News> = ObservableArrayList()
    internal val openDetailNews = SingleLiveEvent<News>()

    fun start(){
        getNews()
    }

    private fun getNews(){
        newsRepository.getNews(object : NewsDataSource.GetNewsCallback{
            override fun onNotAvailable() {
                Toast.makeText(getApplication(),"No Data Found",Toast.LENGTH_SHORT).show()
            }

            override fun onError(msg: String?) {
                Toast.makeText(getApplication(),"Error at "+msg,Toast.LENGTH_SHORT).show()
            }

            override fun onNewsLoaded(news: MutableList<News>?) {
                with(newsList){
                    clear()
                    addAll(news!!)
                }
            }
        })
    }
}