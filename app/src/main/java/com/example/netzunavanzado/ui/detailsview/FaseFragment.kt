package com.example.netzunavanzado.ui.detailsview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netzunavanzado.R
import com.example.netzunavanzado.databinding.FragmentFaseBinding

class FaseFragment : Fragment() {
    private var _binding: FragmentFaseBinding? = null
    private val binding get() = _binding!!
    private var mUsuList: MutableList<Usuario> = mutableListOf()
    private lateinit var adapter: UsuarioAdapter
    var llmanager = LinearLayoutManager(activity)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFaseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        mUsuList.add(Usuario("juan","quispe"))
        mUsuList.add(Usuario("raul","nieri"))


        initRecycler()


        return root
    }
    fun initRecycler() {
        adapter = UsuarioAdapter(mUsuList,
            onClick = { usu -> itemSelected(usu) })
        //val manager = LinearLayoutManager(this)
        //val decoration = DividerItemDecoration(this,manager.orientation )
        with(binding) {
            rvUsuarios.layoutManager = llmanager
            rvUsuarios.adapter = adapter
            //rvSuperHero.addItemDecoration(decoration)
        }
    }


    private fun itemSelected(usu: Usuario) {
        //Toast.makeText(activity, usu.nombre, LENGTH_LONG).show()
        val bundle = Bundle()
        bundle.putString("dato2", "Foo");
        val navController = findNavController()
        navController.navigate(
            R.id.nav_detail_fase, bundle, NavOptions.Builder()
            .setPopUpTo(R.id.nav_home, true)
            .build())
    }

    private fun createUsuario() {
        var usuario1 = Usuario(
            "devsconocido",
            "??????",
        )
        mUsuList.add(1,usuario1)
        adapter.notifyItemInserted(1)
        llmanager.scrollToPositionWithOffset(1,10)
    }

}