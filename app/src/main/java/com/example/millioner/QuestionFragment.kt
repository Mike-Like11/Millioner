package com.example.millioner


import android.R.layout
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton


class QuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var question_number = 1
    private var sum = 0
    private lateinit var viewmodel:QuestionViewModel
    private lateinit var answer_1: MaterialButton
    private lateinit var answer_2: MaterialButton
    private lateinit var answer_3: MaterialButton
    private lateinit var answer_4: MaterialButton
    private lateinit var btn_help1: ImageButton
    private lateinit var btn_help2: ImageButton
    private lateinit var desc: TextView
    private lateinit var cost: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        viewmodel.getQuestionData(question_number)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_question, container, false)
        btn_help1 =v.findViewById(R.id. help1)
        btn_help2 =v.findViewById(R.id. help2)
        desc =v.findViewById(R.id.desc)
        cost =v.findViewById(R.id.cost)
        answer_1 = v.findViewById(R.id.answer1)
        answer_2 = v.findViewById(R.id.answer2)
        answer_3 = v.findViewById(R.id.answert)
        answer_4 = v.findViewById(R.id.answer4)
        viewmodel.question.observe(viewLifecycleOwner) {
            answer_1.text = viewmodel.question.value?.answer_1
            answer_2.text = viewmodel.question.value?.answer_2
            answer_3.text = viewmodel.question.value?.answer_3
            answer_4.text = viewmodel.question.value?.answer_4
            desc.text = viewmodel.question.value?.description
            sum += viewmodel.question.value?.cost!!-10000
            cost.text = "Ваш выигрыш: $sum рублей"
        }
        btn_help1.setOnClickListener {
            btn_help1.setImageResource(R.drawable.ic_baseline_close_24)
            btn_help1.isEnabled = false
            if(!answer_2.text.equals(viewmodel.question.value?.answer_right)){
                ViewCompat.setBackgroundTintList(
                    answer_2,
                    ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.black
                    )
                )
            }
            else{
                ViewCompat.setBackgroundTintList(
                    answer_1,
                    ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.black
                    )
                )
            }
            if(!answer_4.text.equals(viewmodel.question.value?.answer_right)){
                ViewCompat.setBackgroundTintList(
                    answer_4,
                    ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.black
                    )
                )
            }
            else{
                ViewCompat.setBackgroundTintList(
                    answer_3,
                    ContextCompat.getColorStateList(
                        requireContext(),
                        R.color.black
                    )
                )
            }
        }
        btn_help2.setOnClickListener {
            btn_help2.setImageResource(R.drawable.ic_baseline_close_24)
            btn_help2.isEnabled = false
            if(answer_4.text.equals(viewmodel.question.value?.answer_right)) {
                    answer_4.text = viewmodel.question.value?.answer_1 +"- 80 %"
            }
            else{
                answer_4.text = viewmodel.question.value?.answer_1 +"- 15 %"
            }
            if(answer_3.text.equals(viewmodel.question.value?.answer_right)) {
                answer_3.text = viewmodel.question.value?.answer_3 +"- 80 %"
            }
            else{
                answer_3.text = viewmodel.question.value?.answer_3 +"- 5 %"
            }
            if(answer_2.text.equals(viewmodel.question.value?.answer_right)) {
                answer_2.text = viewmodel.question.value?.answer_2 +"- 80 %"
            }
            else{
                answer_2.text = viewmodel.question.value?.answer_2 +"- 5 %"
            }
            if(answer_1.text.equals(viewmodel.question.value?.answer_right)) {
                answer_1.text = viewmodel.question.value?.answer_1 +"- 80 %"
            }
            else{
                answer_1.text = viewmodel.question.value?.answer_1 +"- 0 %"
            }
        }

        answer_1.setOnClickListener {
            change(answer_1)
        }
        answer_2.setOnClickListener {
            change(answer_2)
        }
        answer_3.setOnClickListener {
            change(answer_3)
        }
        answer_4.setOnClickListener {
            change(answer_4)
        }
        return v
    }
    fun change(button: MaterialButton){
            ViewCompat.setBackgroundTintList(
                button,
                ContextCompat.getColorStateList(
                    requireContext(),
                    R.color.teal_200
                )
            )
            Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
                override fun run() {
                    if(button.text.toString().substringBefore('-') .equals(viewmodel.question.value?.answer_right)) {
                        ViewCompat.setBackgroundTintList(
                            button,
                            ContextCompat.getColorStateList(
                                requireContext(),
                                R.color.teal_700
                            )
                        )
                    }
                    else{
                        ViewCompat.setBackgroundTintList(
                            button,
                            ContextCompat.getColorStateList(
                                requireContext(),
                                R.color.red
                            )
                        )
                    }
                }
            },2000)
            Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
                override fun run() {
                    if(button.text.toString().substringBefore('-').equals(viewmodel.question.value?.answer_right)&& question_number!=6) {
                        ViewCompat.setBackgroundTintList(
                            answer_1,
                            ContextCompat.getColorStateList(
                                requireContext(),
                                R.color.million
                            )
                        )
                        ViewCompat.setBackgroundTintList(
                            answer_2,
                            ContextCompat.getColorStateList(
                                requireContext(),
                                R.color.million
                            )
                        )
                        ViewCompat.setBackgroundTintList(
                            answer_3,
                            ContextCompat.getColorStateList(
                                requireContext(),
                                R.color.million
                            )
                        )
                        ViewCompat.setBackgroundTintList(
                            answer_4,
                            ContextCompat.getColorStateList(
                                requireContext(),
                                R.color.million
                            )
                        )
                        question_number++
                        viewmodel.getQuestionData(question_number)
                    }
                    else {
                        if(question_number==6) {
                            Toast.makeText(context, "Вы победили", Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(context, "Вы проиграли", Toast.LENGTH_LONG).show()
                        }
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fragment_content, MenuStart()).commit()
                    }
                }
            },3000)
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFragment().apply {

            }
    }
}