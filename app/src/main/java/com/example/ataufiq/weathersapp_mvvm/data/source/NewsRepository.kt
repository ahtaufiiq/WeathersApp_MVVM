package internship.gits.weatherapps.data.source

import internship.gits.weatherapps.data.News
import internship.gits.weatherapps.data.source.local.NewsLocalDataSource

class NewsRepository(
        val remoteDataSource: NewsDataSource,
        val localDataSource: NewsLocalDataSource
) : NewsDataSource{
    override fun getNews(callback: NewsDataSource.GetNewsCallback) {
        remoteDataSource.getNews(object : NewsDataSource.GetNewsCallback{
            override fun onNewsLoaded(news: MutableList<News>?) {
                callback.onNewsLoaded(news)
            }

            override fun onNotAvailable() {
                callback.onNotAvailable()
            }

            override fun onError(msg: String?) {
                callback.onError(msg)
            }

        })
    }

    companion object {
        private var INSTANCE: NewsRepository? = null

        @JvmStatic
        fun getInstance(newsRemoteDataSource: NewsDataSource, newsLocalDataSource: NewsLocalDataSource) =
                INSTANCE ?: synchronized(NewsRepository::class.java){
                    INSTANCE ?: NewsRepository(newsRemoteDataSource,newsLocalDataSource)
                            .also { INSTANCE = it }
                }

        @JvmStatic
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}