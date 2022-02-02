package com.example.basic.controller

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.widget.*
import androidx.core.content.ContextCompat.getColor
import com.example.basic.R
import com.example.basic.model.Question
import com.example.basic.model.QuestionType
import java.util.*

const val margin: Int = 16

val Int.pixel: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()


class QuestionManager(private val context: Context, private val quiz_container: LinearLayout) {

    private var questions: MutableList<Question> = mutableListOf()

    fun initQuestionManager(){
        setUpQuestions()
        setUpQuiz()
        setSubmitButton()
    }

    private fun setUpQuiz(){
        questions.forEachIndexed { index, question ->
            when(question.type){
                QuestionType.Text ->{
                    setUpTextQuestion(index, question)
                }
                QuestionType.Radio ->{
                    setUpRadioQuestion(index, question)
                }
                QuestionType.CheckBox ->{
                    setUpCheckBoxQuestion(index, question)
                }
            }
        }
    }

    private fun setUpQuestions() {


        questions.add(
            Question(
                1,
                QuestionType.Text,
                "An Application can have how many minimum number of Activity?",
                null, listOf("zero")
            )
        )

        questions.add(
            Question(
                2,
                QuestionType.Radio,
                "To Scale an image in an imageView across the X and Y axis which attribute is used?",
                listOf("fitCenter", "fitXY", "centerCrop", "cropXY"), listOf("fitXY")
            )
        )

        questions.add(
            Question(
                3,
                QuestionType.CheckBox,
                "Android Profiler is used to monitor which of the following resources?(multiple Choice)",
                listOf("CPU", "Memory", "Security Authentication", "Battery", "Network"),
                listOf("CPU", "Memory", "Battery", "Network")
            )
        )
    }

    private fun getQuestionTextView(counter: Int, question: String) : TextView {
        val textView = TextView(context)
        textView.id = counter
        val count = counter + 1
        textView.text = context.getString(R.string.question, count, question)
        12F.also { textView.textSize = it }
        textView.setTextColor(getColor(context, R.color.black))

        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = margin.pixel }

        return textView
    }

    private fun setUpTextQuestion(counter: Int, q: Question) {
        val textView = getQuestionTextView(counter, q.qText)
        val editText = EditText(context)

        editText.id = q.id
        editText.isSingleLine = true
        editText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        quiz_container.addView(textView)
        quiz_container.addView(editText)
    }

    private fun setUpRadioQuestion(counter: Int, q: Question) {
        val textView = getQuestionTextView(counter, q.qText)
        val radioGroup = RadioGroup(context)
        radioGroup.id = q.id
        radioGroup.orientation = RadioGroup.VERTICAL
        radioGroup.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        q.options?.forEachIndexed { index, element ->
            val radioButton = RadioButton(context)
            radioButton.text = element
            radioButton.id = (q.id.toString() + index.toString()).toInt()
            radioButton.textSize = 12F
            radioGroup.addView(radioButton)
        }

        quiz_container.addView(textView)
        quiz_container.addView(radioGroup)
    }

    private fun setUpCheckBoxQuestion(counter: Int, q: Question) {
        val textView = getQuestionTextView(counter, q.qText)
        quiz_container.addView(textView)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        q.options?.forEachIndexed { index, element ->
            val checkBox = CheckBox(context)
            checkBox.text = element
            checkBox.id = (q.id.toString() + index.toString()).toInt()
            checkBox.layoutParams = params
            quiz_container.addView(checkBox)
        }

    }

    private fun setSubmitButton(){

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            topMargin = margin.pixel
            gravity = Gravity.CENTER_HORIZONTAL
        }
        val button = Button(context)
        button.layoutParams = params
        button.text = context.getString(R.string.submit)
        button.setOnClickListener {
            evaluateQuiz()
        }

        quiz_container.addView(button)

    }

    private fun evaluateQuiz() {
        var score = 0

        questions.forEach{ q ->
            when(q.type){
                QuestionType.Text ->{
                    val editText = quiz_container.findViewById<EditText>(q.id)

                    editText?.let{
                        val userAnswer = it.text.toString().lowercase(Locale.getDefault())
                        if(userAnswer == q.answers[0]){
                            score++
                        }
                    }
                }
                QuestionType.Radio -> {
                    val radioGroup = quiz_container.findViewById<RadioGroup>(q.id)

                    radioGroup?.let{
                        val checkedId = it.checkedRadioButtonId
                        if(checkedId > 0){
                            val radioButton = quiz_container.findViewById<RadioButton>(checkedId)
                            val userAnswer = radioButton.text
                            if(userAnswer == q.answers[0]){
                                score++
                            }
                        }
                    }
                }
                QuestionType.CheckBox -> {
                    var correct = true

                    q.options?.forEachIndexed{index, _ ->
                        val checkedId = (q.id.toString() + index.toString()).toInt()
                        val checkBox =  quiz_container.findViewById<CheckBox>(checkedId)
                        if(q.answers.contains(checkBox.text)){
                            if(!checkBox.isChecked){
                                correct = false
                            }
                        } else{
                            if(checkBox.isChecked){
                                correct = false
                            }
                        }
                    }
                    if(correct) score++
                }
            }
        }
        Toast.makeText(context, context.getString(R.string.score_result, score, questions.size), Toast.LENGTH_SHORT).show()
    }
}