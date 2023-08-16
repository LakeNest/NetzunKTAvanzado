package com.example.netzunavanzado.ui.widgets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.netzunavanzado.databinding.FragmentWidgetsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar


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

        /***ratingBar***/
        val ratingBar = binding.ratingBar
        ratingBar.max = 8
        ratingBar.numStars = 7
        ratingBar.rating = 5f
        ratingBar.setIsIndicator(false)
        ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            Toast.makeText(activity,"el rating es $fl", Toast.LENGTH_LONG).show()
        }
        /***ratingBar***/


        /***ProgressBar***/
        val pbHorizontal = binding.pbLinear
        pbHorizontal.max = 500
        pbHorizontal.progress = 200

        GlobalScope.launch {
            updateProgressBar(pbHorizontal)
        }
        /***ProgressBar***/


        /***CalendarView***/
        val btnOpenCal = binding.btnOpenCalendar
        val calendarView = binding.calendarView
        val tvDateSelect = binding.tvDateSelected
        val flCalendar = binding.flCalendar
        btnOpenCal.setOnClickListener {
            if(flCalendar.isGone){
                flCalendar.visibility = View.VISIBLE
            } else  flCalendar.visibility = View.GONE
            calendarView.setOnDateChangeListener { calendarView, year, month, day ->
                var date = "$day/${month+1}/$year"
                tvDateSelect.text = date
            }

            val calendario = Calendar.getInstance()
            calendario.set(2025,2,10)
            calendarView.date = calendario.timeInMillis
        }
        /***CalendarView***/


        /***WebView***/
        val webView = binding.webView
        webView.loadUrl("https://www.google.com")
        // Enable Javascript
        val webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
        // Force links and redirects to open in the WebView instead of in a browser
        webView.webViewClient = WebViewClient()
        /***WebView***/

        /***VideoView***/
        val videoViewWeb = binding.videoViewWeb
        var mediaController = MediaController(context)
        mediaController.setAnchorView(videoViewWeb)
        videoViewWeb.setVideoPath("https://wankusoftware.com/video/chichenol.mp4")
        videoViewWeb.setMediaController(mediaController)
        /***VideoView***/
        return root
    }
    suspend fun updateProgressBar(progressBar:ProgressBar){
        while(progressBar.progress < progressBar.max){
            delay(100)
            progressBar.incrementProgressBy(10)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}