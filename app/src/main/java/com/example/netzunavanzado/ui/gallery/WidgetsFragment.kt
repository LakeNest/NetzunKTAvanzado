package com.example.netzunavanzado.ui.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.netzunavanzado.databinding.FragmentWidgetsBinding


class WidgetsFragment : Fragment() {

    private var _binding: FragmentWidgetsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(WidgetsViewModel::class.java)

        _binding = FragmentWidgetsBinding.inflate(inflater, container, false)
        val root: View = binding.root




        val webView = binding.webView
        webView.loadUrl("https://www.google.com")
        // Enable Javascript
        val webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
        // Force links and redirects to open in the WebView instead of in a browser
        webView.webViewClient = WebViewClient()

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        val videoViewLocal = binding.videoViewLocal

        val videoViewWeb = binding.videoViewWeb
        var mediaController = MediaController(context)
        mediaController.setAnchorView(videoViewWeb)
        videoViewWeb.setVideoPath("https://wankusoftware.com/video/chichenol.mp4")
        videoViewWeb.setMediaController(mediaController)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}