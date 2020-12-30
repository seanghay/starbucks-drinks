package com.seanghay.starbucksdrinks.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.seanghay.resultof.onSuccess
import com.seanghay.starbucksdrinks.databinding.FragmentRecommendedBinding
import com.seanghay.starbucksdrinks.epoxy.RecommendedController

class RecommendedFragment : Fragment() {

    private var _binding: FragmentRecommendedBinding? = null
    private val binding: FragmentRecommendedBinding get() = _binding!!
    private val viewModel: RecommendedViewModel by viewModels()

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
        binding.epoxyRecyclerView.setController(controller)

        viewModel.featuredProducts.observe(viewLifecycleOwner) { result ->
            result.onSuccess { featuredProducts ->
                controller.submitFeaturedProducts(featuredProducts)
            }
        }

        viewModel.popularDrinks.observe(viewLifecycleOwner) {
            it.onSuccess(controller::submitPopularDrinks)
        }

        viewModel.signatureDrinks.observe(viewLifecycleOwner) {
            it.onSuccess(controller::submitSignatureDrinks)
        }

        viewModel.allProducts.observe(viewLifecycleOwner) {
            it.onSuccess(controller::submitAll)
        }

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