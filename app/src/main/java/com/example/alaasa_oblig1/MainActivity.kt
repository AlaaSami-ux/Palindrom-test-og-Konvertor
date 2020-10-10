package com.example.alaasa_oblig1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but1()
        but2()
    }

    @SuppressLint("SetTextI18n")
    fun but1() {
        button2.setOnClickListener {
            var firstTekst = editText1.text.toString()
            //     textView_test.text = "Teksten er Palindrom $firstTekst "

            var reverse: String = ""
            var l: Int = firstTekst.length - 1
            while (l != -1) {
                reverse += firstTekst[l--]
            }
            if (firstTekst.length == 0)
                textView_test.text = "Feil prøv igjen"
            else if (firstTekst == reverse)
                textView_test.text = "Teksten er Palindrom $firstTekst "
            else
                textView_test.text = "Teksten er ikke Palindrom $firstTekst "
        editText1.onEditorAction(EditorInfo.IME_ACTION_DONE)
        //editText1.text.clear()
        }

    }

    fun but2() {
        button3.setOnClickListener {
            val firstTekst = editText1.text.toString()
            //     textView_test.text = "Teksten er Palindrom $firstTekst "
            val intent = Intent(this, ConverterAktivity::class.java)
            var reverse: String = ""
            var l: Int = firstTekst.length - 1
            while (l != -1) {
                reverse += firstTekst[l--];
            }
            if (firstTekst.isEmpty())
                textView_test.text = "Feil prøv igjen"
            else {
                intent.putExtra("neste-aktivitet", firstTekst)
                startActivity(intent)
            }
        }
    }
}


