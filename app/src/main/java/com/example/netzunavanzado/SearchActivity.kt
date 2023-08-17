package com.example.netzunavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SearchView
import com.example.netzunavanzado.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var binding:ActivitySearchBinding
    private val list = listOf("pollo", "pescado", "gallina", "huevos")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val svBuscar = binding.svSearchItemBuy
        val etCompras = binding.etListaCompras

        etCompras.setText(listToString(list))
        svBuscar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.svSearchItemBuy.clearFocus()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                allOper(p0,etCompras)
                return false
            }

        })

    }
    private fun listToString(list:List<String>):String{
        var string = ""
        list.forEach {
            string = string+it+"\n"
        }
    return string
    }

    private fun searchList(text:String?):List<String>{
        val filterList = list.filter {
            it.contains(text?:"",true)
        }
        return filterList
    }

    fun allOper(text: String?, multiline:EditText){
        val newList = searchList(text)
        val newString = listToString(newList)
        multiline.setText(newString)
    }
}