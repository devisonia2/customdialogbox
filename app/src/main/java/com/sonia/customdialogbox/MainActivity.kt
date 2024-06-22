package com.sonia.customdialogbox

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sonia.customdialogbox.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.btnShowCustomDialog?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.customdialog)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            var btnSubmit = dialog.findViewById<Button>(R.id.btnSubmit)
            var btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
            var etName = dialog.findViewById<EditText>(R.id.etname)
            btnSubmit.setOnClickListener {
                if (etName?.text?.toString()?.trim().isNullOrEmpty()) {
                    etName?.error = "Enter Your Name"
                } else {
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }
}