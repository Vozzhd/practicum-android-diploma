package ru.practicum.android.diploma.filters.areas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.practicum.android.diploma.R
import ru.practicum.android.diploma.databinding.WorkingRegionFragmentBinding

class WorkingRegionFragment : Fragment() {
    private var _binding: WorkingRegionFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WorkingRegionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.countrySelect.setOnClickListener {
            findNavController().navigate(R.id.action_workingRegionFragment_to_countrySelectFragment)
        }
        binding.regionSelect.setOnClickListener {
            findNavController().navigate(R.id.action_workingRegionFragment_to_citySelectFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}