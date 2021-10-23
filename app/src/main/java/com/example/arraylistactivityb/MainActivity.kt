package com.example.arraylistactivityb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var edName:EditText
    lateinit var edNameNum:EditText
    lateinit var btnAdd:Button
    lateinit var btnGet:Button
    lateinit var tvName:TextView
    lateinit var nameList:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName=findViewById(R.id.edName)
        edNameNum=findViewById(R.id.edNameNum)
        btnAdd=findViewById(R.id.btnAdd)
        btnGet=findViewById(R.id.btnGet)
        tvName=findViewById(R.id.tvName)

        nameList= arrayListOf()

        btnAdd.setOnClickListener(){
            if (edName.text.isNotEmpty()){
                val name=edName.text.toString()
                nameList.add(name)
                edName.text.clear()
                Toast.makeText(applicationContext, "$name is added", Toast.LENGTH_SHORT).show()
            }
            if (nameList.size==10){
                edNameNum.visibility=View.VISIBLE
                btnGet.visibility=View.VISIBLE
                tvName.visibility=View.VISIBLE
            }//end if
        }//end btnAdd listener


        btnGet.setOnClickListener(){
            if (edNameNum.text.isNotEmpty()){
                tvName.text=nameList[edNameNum.text.toString().toInt()]
                edName.text.clear()
            }
        }//end btnGet listener

    }//end onCreate()

}//end class