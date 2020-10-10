package com.example.alaasa_oblig1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_converter_aktivity.*
import kotlinx.android.synthetic.main.activity_converter_aktivity.view.*
import kotlinx.android.synthetic.main.activity_main.*

class ConverterAktivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_aktivity)

      //  val tekstFraAktvitet1 = intent.getStringExtra("neste-aktivitet")
        //Toast.makeText(this," Ny aktivitet:  $tekstFraAktvitet1", Toast.LENGTH_LONG).show()

        val mySpinner= spinner9
        mySpinner.onItemSelectedListener=this
        but4()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        myTextView2.text = "Velg en av alternativene "
        //Toast.makeText(this," Ny aktivitet: INGENTING", Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val selectedItem = parent.getItemAtPosition(position).toString()
        Konverter.setOnClickListener{
            if (selectedItem == "Spinner"){
                onNothingSelected(parent)
            } else if ( selectedItem == "fluid ounce"){
                Toast.makeText(this," Ny aktivitet: $selectedItem", Toast.LENGTH_LONG).show()
                val converter = Integer.parseInt(tallTOConvert.text.toString())
                var result = converter * 0.02957
                myTextView2.text = "Det er : $result\n fl oz"
            }else if( selectedItem == "cup"){
                Toast.makeText(this," Ny aktivitet: $selectedItem", Toast.LENGTH_LONG).show()
                val converter = Integer.parseInt(tallTOConvert.text.toString())
                var result = converter * 0.23659
                myTextView2.text = "Det er : $result \n CUP"
            }else if( selectedItem == "gallon"){
                Toast.makeText(this," Ny aktivitet: $selectedItem", Toast.LENGTH_LONG).show()
                val converter = Integer.parseInt(tallTOConvert.text.toString())
                var result = converter * 3.78541
                myTextView2.text = "Det er : $result \n Gallon"
            }else if( selectedItem == "hogshead"){
                Toast.makeText(this," Ny aktivitet: $selectedItem", Toast.LENGTH_LONG).show()
                val converter = Integer.parseInt(tallTOConvert.text.toString())
                var result = converter * 238.481
                myTextView2.text = "Det er : $result \n Hogshead"
            }
            tallTOConvert.onEditorAction(EditorInfo.IME_ACTION_DONE)
        }
       // but4()
    }
    fun but4(){
        val tekstFraAktvitet1 = intent.getStringExtra("neste-aktivitet")
        button4.setOnClickListener{
            val intent = Intent(this,QuizActivity::class.java)
            intent.putExtra("neste-aktivitet3",tekstFraAktvitet1)
            startActivity(intent)

        }
    }



}
