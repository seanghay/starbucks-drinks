package com.seanghay.starbucksdrinks.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.seanghay.starbucksdrinks.databinding.FragmentRecommendedBinding
import com.seanghay.starbucksdrinks.epoxy.RecommendedController

class RecommendedFragment : Fragment() {

    private var _binding: FragmentRecommendedBinding? = null
    private val binding: FragmentRecommendedBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = RecommendedController()
        binding.epoxyRecyclerView.setControllerAndBuildModels(controller)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        @JvmStatic
        fun newInstance(): RecommendedFragment {
            return RecommendedFragment()
        }
    }
}