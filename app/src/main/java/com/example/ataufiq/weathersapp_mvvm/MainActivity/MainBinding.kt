package internship.gits.weatherapps.news

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import internship.gits.weatherapps.data.News

object MainBinding {
    @BindingAdapter("app:newsList")
    @JvmStatic
    fun setNewsList(recyclerView: RecyclerView, news: MutableList<News>) {
        with(recyclerView.adapter as MainAdapter){
            replaceData(news)
        }
    }
}