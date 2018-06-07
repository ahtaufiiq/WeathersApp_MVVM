package com.example.ataufiq.weathersapp_mvvm.MainActivity


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ataufiq.weathersapp_mvvm.databinding.FragmentMainBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    private lateinit var viewBinding: FragmentMainBinding
    private lateinit var mainAdapter: MainAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentMainBinding.inflate(inflater, container, false).apply {
            vm = (activity as MainActivity).obtainViewModel()
        }
        return viewBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupWeather()
    }

    private fun setupWeather() {
        val viewModel = viewBinding.vm
        if(viewModel != null){
            mainAdapter = MainAdapter(viewModel.weatherList,viewModel)
            viewBinding.rvWeatherFrag.adapter = mainAdapter
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
