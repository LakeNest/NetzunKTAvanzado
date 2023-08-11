package com.example.netzunavanzado.ui.fase

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.netzunavanzado.databinding.UsuarioListBinding


class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding = UsuarioListBinding.bind(itemView)

    fun render(usuario: Usuario, onClick: (Usuario) -> Unit){
        with(binding){
            textView3.text = usuario.nombre
            textView4.text = usuario.apellido

            /*ivSuperHero.setOnClickListener{Toast.makeText(ivSuperHero.context, "Hola",LENGTH_LONG)
                .show()}*/
            itemView.setOnClickListener { onClick(usuario)}
        }

    }
}