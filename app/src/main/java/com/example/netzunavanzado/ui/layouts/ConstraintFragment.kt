package com.example.netzunavanzado.ui.layouts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.netzunavanzado.databinding.FragmentConstraintBinding

class ConstraintFragment : Fragment() {
    private var _binding:FragmentConstraintBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentConstraintBinding.inflate(layoutInflater, container,false)
        val root = binding.root
        val btnAddAlpha = binding.btnAlphaAdd
        val btnMinusAlpha = binding.btnAlphaMinus
        val btnAddRotate = binding.btnRotateAdd
        val btnMinusRotate = binding.btnRotateMinus
        val btnAddScale = binding.btnScaleAdd
        val btnMinusScale = binding.btnScaleMinus
        val ivCineplanet = binding.ivCineplanet
        btnAddAlpha.setOnClickListener {
            if (ivCineplanet.alpha < 1) ivCineplanet.alpha += 0.1f
        }
        btnMinusAlpha.setOnClickListener {
            if (ivCineplanet.alpha > 0) ivCineplanet.alpha -= 0.1f
        }
        btnAddScale.setOnClickListener {
            ivCineplanet.scaleX += 0.1f
            ivCineplanet.scaleY += 0.1f
        }
        btnMinusScale.setOnClickListener {
            ivCineplanet.scaleX -= 0.1f
            ivCineplanet.scaleY -= 0.1f
        }
        btnAddRotate.setOnClickListener {
            ivCineplanet.rotation += 15
        }
        btnMinusRotate.setOnClickListener {
            ivCineplanet.rotation -= 15
        }


        return root
    }


}