package com.example.netzunavanzado.ui

import android.os.Bundle
import com.example.netzunavanzado.ui.slideshow.TextviewsFragment
import java.io.Serializable

interface IDetailsFragmentDelegate:Serializable {
    fun onSomething1(someData1: String)
    fun onSomething2(someData2: String)
}