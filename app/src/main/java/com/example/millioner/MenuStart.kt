package com.example.millioner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.volley.toolbox.HttpResponse
import com.google.android.material.button.MaterialButton
import io.ktor.client.*
import io.ktor.client.request.*
import org.json.JSONTokener

class MenuStart : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_menu_start, container, false)
        val btn = v.findViewById(R.id.gameStart) as MaterialButton
        btn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_content, QuestionFragment()).commit()
        }
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuStart().apply {

            }
            }
}
