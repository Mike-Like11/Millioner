package com.example.millioner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuStart.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuStart : Fragment() {
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
        val v = inflater.inflate(R.layout.fragment_menu_start, container, false)
        val btn = v.findViewById(R.id.gameStart) as MaterialButton
        var viewmodel = ViewModelProvider(this).get(MenuStartViewModel::class.java)
        val test1 = Test(name = "Test1",  id = 0)
        val test2 = Test(name = "Test2",  id = 1)
        viewmodel.insert(test1)
        viewmodel.insert(test2)
        btn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_content, QuestionFragment()).commit()
            Toast.makeText(context,"dasdsadsadasdasdas",Toast.LENGTH_SHORT).show()
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
         * @return A new instance of fragment MenuStart.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuStart().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


/**
 * A simple [Fragment] subclass.
 * Use the [MenuStart.newInstance] factory method to
 * create an instance of this fragment.
 */
//class MenuStart : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val v = inflater.inflate(R.layout.fragment_menu_start, container, false)
//        val btn = v.findViewById(R.id.gameStart) as MaterialButton
//        btn.setOnClickListener {
//            parentFragmentManager.beginTransaction().replace(R.id.fragment_content, QuestionFragment()).commit()
//            Toast.makeText(context,"dasdsadsadasdasdas",Toast.LENGTH_SHORT).show()
//        }
//        return v
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment MenuStart.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            MenuStart().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//}