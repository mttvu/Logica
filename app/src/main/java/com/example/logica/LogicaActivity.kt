package com.example.logica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_logica.*

class LogicaActivity : AppCompatActivity() {

    private var submitting = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logica)
        initViews()
    }

    private fun initViews(){
        btnSubmit.setOnClickListener { onSubmitClick() }
    }

    private fun onSubmitClick(){
        if(submitting){
            checkAnswers()
            btnSubmit.text = getString(R.string.tryagain)

        }else{
            tryAgain()
            btnSubmit.text = getString(R.string.submit)
        }

        submitting = !submitting
    }

    private fun tryAgain(){
        //clear the edittexts so you can make another attempt
        etCase1Answer.text.clear()
        etCase2Answer.text.clear()
        etCase3Answer.text.clear()
        etCase4Answer.text.clear()

    }

    private fun checkAnswers(){
        //check answers of every case, if the answer is incorrect show an incorrect toast message and return
        if(!etCase1Answer.text.toString().equals(getString(R.string.t), ignoreCase = true)){
            onAnswerIncorrect()
            return
        }

        if(!etCase2Answer.text.toString().equals(getString(R.string.f), ignoreCase = true)){
            onAnswerIncorrect()
            return
        }

        if(!etCase3Answer.text.toString().equals(getString(R.string.f), ignoreCase = true)){
            onAnswerIncorrect()
            return
        }

        if(!etCase4Answer.text.toString().equals(getString(R.string.f), ignoreCase = true)){
            onAnswerIncorrect()
            return
        }
        onAnswerCorrect()


    }
    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
}
