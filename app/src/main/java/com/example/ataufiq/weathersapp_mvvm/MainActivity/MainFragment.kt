package internship.gits.weatherapps.news


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ataufiq.weathersapp_mvvm.MainActivity.MainActivity
import com.example.ataufiq.weathersapp_mvvm.databinding.MainFragBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    private lateinit var viewBinding: MainFragBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewBinding = MainFragBinding.inflate(inflater, container, false).apply {
            vm = (activity as MainActivity).obtainViewModel()
        }
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupNews()
    }

    private fun setupNews() {
        val viewModel = viewBinding.vm
        if(viewModel != null){
            mainAdapter = MainAdapter(viewModel.newsList,viewModel)
            viewBinding.rvNewsFrag.adapter = mainAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewBinding.vm?.start()

    }

    companion object {
        fun newInstance() = MainFragment().apply {

        }
    }
}
