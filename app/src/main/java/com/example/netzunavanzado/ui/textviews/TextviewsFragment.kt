package com.example.netzunavanzado.ui.textviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.netzunavanzado.databinding.FragmentTextviewsBinding

class TextviewsFragment : Fragment() {

    private var _binding: FragmentTextviewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(TextviewsViewModel::class.java)

        _binding = FragmentTextviewsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        val textView2 = binding.textView2
        /*Recibir datos entre fragments por Bundle*/
        val getDato2 = arguments?.getString("dato2")
        textView2.text = getDato2


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}