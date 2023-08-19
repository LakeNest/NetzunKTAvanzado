package com.example.netzunavanzado.ui.admob

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.netzunavanzado.databinding.FragmentAdmobBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds



class AdmobFragment : Fragment() {
    private var _binding: FragmentAdmobBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAdmobBinding.inflate(inflater, container, false)


        /***Desplegar banner admob***/
        MobileAds.initialize(requireContext())
        val avBanner = binding.avBanner
        val adRequest = AdRequest.Builder().build()
        avBanner.loadAd(adRequest)
        avBanner.adListener = object : AdListener() {
            override fun onAdClicked() {
                Toast.makeText(activity,"has echo click", Toast.LENGTH_LONG).show()
            }
        }
        /***Desplegar banner admob***/


        return binding.root
    }

}