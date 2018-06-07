package internship.gits.weatherapps.news

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ataufiq.weathersapp_mvvm.R
import com.example.ataufiq.weathersapp_mvvm.databinding.MainRowBinding
import internship.gits.weatherapps.data.News
import internship.gits.weatherapps.util.load

class MainAdapter(private var news: MutableList<News>, private var mainViewModel: MainViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val newsRowBinding : MainRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.main_row,parent,false)
        return NewsRowHolder(newsRowBinding)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val datas = news[position]
        val actionListener = object : WeathersItemUserActionListener{
            override fun onNewsClicked(news: News) {
                mainViewModel.openDetailNews.value = news
            }

        }
        (holder as NewsRowHolder).bindRows(datas,actionListener)
    }

    fun replaceData(news: MutableList<News>){
        setList(news)
    }

    fun setList(news: MutableList<News>){
        this.news = news
        notifyDataSetChanged()
    }

    class NewsRowHolder(binding: MainRowBinding) : RecyclerView.ViewHolder(binding.root){
        val newsRowBinding = binding

        fun bindRows(news: News, userActionListener: WeathersItemUserActionListener) {
            newsRowBinding.datas =  news
            newsRowBinding.action = userActionListener
            newsRowBinding.executePendingBindings()
            if(news.urlToImage!= null)
                newsRowBinding.ivRowNewsImage.load(news.urlToImage!!){
                    requestCreator -> requestCreator.fit().centerCrop()
                }
        }
    }
}