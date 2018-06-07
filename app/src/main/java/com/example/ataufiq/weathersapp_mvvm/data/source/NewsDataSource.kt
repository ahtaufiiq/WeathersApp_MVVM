package internship.gits.weatherapps.data.source

import internship.gits.weatherapps.data.News

interface NewsDataSource {
    fun getNews(callback: GetNewsCallback)

    interface GetNewsCallback {
        fun onNewsLoaded(news: MutableList<News>?)
        fun onNotAvailable()
        fun onError(msg : String?)
    }
}