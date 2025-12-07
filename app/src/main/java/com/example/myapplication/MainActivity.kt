package com.example.myapplication

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityLearnWordBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnWordBinding
    private val trainer = LearnWordsTrainer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnContinue.setOnClickListener {
                resetAnswers()
                layoutResult.isVisible = false
                showNextQuestion()
            }
            btnSkip.setOnClickListener { showNextQuestion() }
        }

        showNextQuestion()
    }

    private fun showNextQuestion() {
        val question = trainer.getNextQuestion()
        with(binding) {
            if (question == null || question.variants.size < NUMBER_OF_ANSWERS) {
                tvQuestionWord.isVisible = false
                layoutVariants.isVisible = false
                btnSkip.text = "Complete"
                return
            }

            btnSkip.isVisible = true
            tvQuestionWord.isVisible = true
            tvQuestionWord.text = question.correctAnswer.original

            val layouts = listOf(layoutAnswer1, layoutAnswer2, layoutAnswer3, layoutAnswer4)
            val numbers =
                listOf(tvVariantNumber1, tvVariantNumber2, tvVariantNumber3, tvVariantNumber4)
            val values = listOf(tvVarintValue1, tvVarintValue2, tvVarintValue3, tvVarintValue4)

            question.variants.forEachIndexed { index, variant ->
                values[index].text = variant.translate
                layouts[index].setOnClickListener {
                    if (trainer.checkAnswer(index)) {
                        markAnswerCorrect(layouts[index], numbers[index], values[index])
                        showResultMessage(true)
                    } else {
                        markAnswerWrong(layouts[index], numbers[index], values[index])
                        showResultMessage(false)
                    }
                }
            }
        }
    }

    private fun resetAnswers() = with(binding) {
        val layouts = listOf(layoutAnswer1, layoutAnswer2, layoutAnswer3, layoutAnswer4)
        val numbers = listOf(tvVariantNumber1, tvVariantNumber2, tvVariantNumber3, tvVariantNumber4)
        val values = listOf(tvVarintValue1, tvVarintValue2, tvVarintValue3, tvVarintValue4)

        layouts.indices.forEach { i ->
            markAnswerNeutral(layouts[i], numbers[i], values[i])
        }
    }

    private fun markAnswerNeutral(layout: LinearLayout, tvNumber: TextView, tvValue: TextView) {
        layout.background = ContextCompat.getDrawable(this, R.drawable.shape_rounded_containers)
        tvValue.setTextColor(ContextCompat.getColor(this, R.color.black))
        tvNumber.apply {
            background =
                ContextCompat.getDrawable(this@MainActivity, R.drawable.shape_rounded_variants)
            setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
        }
    }

    private fun markAnswerCorrect(layout: LinearLayout, tvNumber: TextView, tvValue: TextView) {
        layout.background =
            ContextCompat.getDrawable(this, R.drawable.shape_rounded_containers_correct)
        tvNumber.background =
            ContextCompat.getDrawable(this, R.drawable.shape_rounded_variants_correct)
        tvNumber.setTextColor(ContextCompat.getColor(this, R.color.white))
        tvValue.setTextColor(ContextCompat.getColor(this, R.color.green))
    }

    private fun markAnswerWrong(layout: LinearLayout, tvNumber: TextView, tvValue: TextView) {
        layout.background =
            ContextCompat.getDrawable(this, R.drawable.shape_rounded_containers_wrong)
        tvNumber.background =
            ContextCompat.getDrawable(this, R.drawable.shape_rounded_variants_wrong)
        tvNumber.setTextColor(ContextCompat.getColor(this, R.color.white))
        tvValue.setTextColor(ContextCompat.getColor(this, R.color.red))
    }

    private fun showResultMessage(isCorrect: Boolean) {
        val (color, icon, text) = if (isCorrect) {
            Triple(
                ContextCompat.getColor(this, R.color.green),
                R.drawable.thumbs_up_3_1_,
                "Correct!"
            )
        } else {
            Triple(
                ContextCompat.getColor(this, R.color.red),
                R.drawable.thumbs_down_3,
                "Incorrect!"
            )
        }

        with(binding) {
            btnSkip.isVisible = false
            layoutResult.isVisible = true
            btnContinue.setTextColor(color)
            layoutResult.setBackgroundColor(color)
            tvResult.text = text
            ivResultIcon.setImageResource(icon)
        }
    }
}


