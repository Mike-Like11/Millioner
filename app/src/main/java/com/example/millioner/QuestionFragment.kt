package com.example.millioner

import android.content.res.ColorStateList
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.google.android.material.button.MaterialButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_question, container, false)
        val btn_help1 =v.findViewById(R.id. help1) as ImageButton
        btn_help1.setOnClickListener {
            btn_help1.setImageResource(R.drawable.ic_baseline_close_24)
            btn_help1.isEnabled = false
        }
        val btn_help2 =v.findViewById(R.id. help2) as ImageButton
        btn_help2.setOnClickListener {
            btn_help2.setImageResource(R.drawable.ic_baseline_close_24)
            btn_help2.isEnabled = false
        }

        val answer_1 = v.findViewById(R.id.answer1) as MaterialButton
        answer_1.setOnClickListener {
            ViewCompat.setBackgroundTintList(
                answer_1,
                ContextCompat.getColorStateList(
                    requireContext(),
                    R.color.teal_200
                )
            );
            Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
                override fun run() {
                    ViewCompat.setBackgroundTintList(
                        answer_1,
                        ContextCompat.getColorStateList(
                            requireContext(),
                            R.color.teal_700
                        )
                    );
                }
            },2000)
        }
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}