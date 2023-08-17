package com.example.netzunavanzado.ui.layouts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.netzunavanzado.databinding.FragmentLinearBinding


class LinearFragment : Fragment() {

    private var _binding: FragmentLinearBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLinearBinding.inflate(layoutInflater, container, false)



        return binding.root
    }


}