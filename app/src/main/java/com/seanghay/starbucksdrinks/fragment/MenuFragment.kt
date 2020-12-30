package com.seanghay.starbucksdrinks.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.seanghay.starbucksdrinks.databinding.FragmentMenuBinding
import com.seanghay.starbucksdrinks.epoxy.MenuController

class MenuFragment: Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = MenuController()
        binding.epoxyRecyclerView.setControllerAndBuildModels(controller)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }
}