package com.example.netzunavanzado.ui.home



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.example.netzunavanzado.R
import com.example.netzunavanzado.databinding.FragmentButtonsBinding
import com.example.netzunavanzado.ui.slideshow.TextviewsFragment
import com.google.android.material.chip.Chip


class ButtonsFragment : Fragment() {

    private var _binding: FragmentButtonsBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(ButtonsViewModel::class.java)

        _binding = FragmentButtonsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btn1 = binding.btn1
        val btn2 = binding.btn2
        val btn3 = binding.button3
        val radioGroup = binding.radioGroup
        val draw = ContextCompat.getDrawable(
            btn3.context,
            R.drawable.bg_gradient
        )



        btn1.setOnClickListener {
            //Enviar datos entre fragments por Bundle


            /*requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_home, fragment)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()*/

            /*Enviar datos y pasar a otro fragment*/
            val bundle = Bundle()
            bundle.putString("dato2", "Foo");
            val navController = findNavController()
            navController.navigate(R.id.nav_slideshow, bundle, NavOptions.Builder()
                .setPopUpTo(R.id.nav_home, true)
                .build())


        }



        btn3.text = "Añadir Chip"
        btn3.background = draw
        btn3.setOnClickListener {
            addChip()
        }

        btn2.setOnClickListener {
            val id = radioGroup.checkedRadioButtonId
            val rb = view?.findViewById<RadioButton>(id)
            if (rb != null) {
                Toast.makeText(radioGroup.context,"${rb.text} elegido", Toast.LENGTH_SHORT).show()
            }
        }

        val rButton = radioGroup.getChildAt(1) as RadioButton
        rButton.text = "Mujer"
        radioGroup.check(binding.radioButton.id)


        val chipGroup = binding.chipGroup
        var chip:Chip
        for(i in 0 until chipGroup.childCount){
            chip = chipGroup.getChildAt(i) as Chip
            chip.setOnCloseIconClickListener {
                chipGroup.removeView(it)
            }
            chip.setOnClickListener {
                val temp = it as Chip
                Toast.makeText(chip.context,"${temp.text} Pulsadoxx", Toast.LENGTH_SHORT).show()
            }
        }





        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun addChip(){
        val chipGroup = binding.chipGroup
        val chip = Chip(chipGroup.context)
        chip.text = "Nuevo Chip"
        chip.chipIcon = ContextCompat.getDrawable(chipGroup.context, com.example.netzunavanzado.R.drawable.ic_fire)
        chip.isCloseIconVisible = true

        chip.setOnCloseIconClickListener {
            chipGroup.removeView(chip)
        }

        chip.setOnClickListener {
            Toast.makeText(chip.context,"${chip.text} Pulsado", Toast.LENGTH_SHORT).show()
        }
        chipGroup.addView(chip)
    }
}