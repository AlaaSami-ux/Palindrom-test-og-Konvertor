package com.example.alaasa_oblig1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    var poeng = 0
    var i = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        val mList: MutableList<Question> = mutableListOf()
        mList.add(Question("Landområdet som USA kjøpte fra Russland i 1867 er Alaska", true))
        mList.add(Question("Årstallet som ‘Titanic’ sank er 1913", false))
        mList.add(Question("En liter gull veier mer enn en liter sølv ", true))
        mList.add(Question("En liter gull veier mindre enn en liter sølv ", false))


        firstText()
        faktaFleipButt(mList)
      // resultaten.text = "Antall Poeng:" + poeng.toString()
    }

    fun firstText() {
        val tekstFraAktvitet2 = intent.getStringExtra("neste-aktivitet3")
      //  Toast.makeText(this, " Ny aktivitet:  $tekstFraAktvitet2", Toast.LENGTH_LONG).show()
        myLastText.text = tekstFraAktvitet2
    }

    data class Question(var spaarsmaal: String, var sannhet: Boolean)

    @SuppressLint("SetTextI18n")
    fun faktaFleipButt(list: MutableList<Question>) {
        quizTekst.text = list.get(i).spaarsmaal
        fleipBut.setOnClickListener {
            if (i == (list.size)) {
                fleipBut.isClickable = false
            } else if (!list.get(i).sannhet) {
                poeng++
                quizTekst.text = list.get(i).spaarsmaal
                i++
            } else if (list.get(i).sannhet) {
                quizTekst.text = list.get(i).spaarsmaal
                i++
            }
            resultaten.text = "Antall Poeng:" + poeng.toString()
        }
        factBut.setOnClickListener {
            if (i == (list.size)) {
                factBut.isClickable = false
            } else if (list.get(i).sannhet) {
                poeng++
                quizTekst.text = list.get(i).spaarsmaal
                i++
            } else if (!list.get(i).sannhet) {
                quizTekst.text = list.get(i).spaarsmaal
                i++
            }
            resultaten.text = "Antall Poeng:" + poeng.toString()
        }
        resultaten.text = "Antall Poeng:" + poeng.toString()
    }
}
