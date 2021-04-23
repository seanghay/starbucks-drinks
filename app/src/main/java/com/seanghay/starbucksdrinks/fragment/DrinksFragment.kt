package com.seanghay.starbucksdrinks.fragment



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.seanghay.resultof.onSuccess
import com.seanghay.starbucksdrinks.databinding.FragmentDrinksBinding
import com.seanghay.starbucksdrinks.epoxy.RecommendedController

class DrinksFragment : Fragment() {

    private var _binding: FragmentDrinksBinding? = null
    private val binding: FragmentDrinksBinding get() = _binding!!
    private val viewModel: RecommendedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDrinksBinding.inflate(inflater, container, false)
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
        fun newInstance(): DrinksFragment {
            return DrinksFragment()
        }
    }
}