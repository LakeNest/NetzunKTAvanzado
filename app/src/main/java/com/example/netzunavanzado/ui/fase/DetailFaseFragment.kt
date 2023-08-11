package com.example.netzunavanzado.ui.fase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.netzunavanzado.databinding.FragmentDetailFaseBinding


class DetailFaseFragment : Fragment() {
    private var _binding: FragmentDetailFaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailFaseBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val getDato2 = arguments?.getString("dato2")
        Toast.makeText(activity, "Hola $getDato2", Toast.LENGTH_LONG).show()


        return root

    }

}