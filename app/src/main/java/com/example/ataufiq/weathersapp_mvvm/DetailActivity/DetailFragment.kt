package com.example.ataufiq.weathersapp_mvvm.DetailActivity


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ataufiq.weathersapp_mvvm.databinding.FragmentDetailBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailFragment : Fragment() {
    private lateinit var viewBinding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return viewBinding.root

    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        fun newInstance(bundle:Bundle) = DetailFragment().apply {
            arguments = bundle
        }
    }
}