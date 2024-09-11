package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getUsn = intent.getStringExtra(Register.EXTRA_USERNAME)
        val getPsw = intent.getStringExtra(Register.EXTRA_PASSWORD)
        val getEmail = intent.getStringExtra(Register.EXTRA_EMAIL)
        val getPhone = intent.getStringExtra(Register.EXTRA_PHONE)
        with(binding){
            btnLogin.setOnClickListener{
                val edtUsn = logUsn.text.toString()
                val edtPsw = logPsw.text.toString()
                if(edtUsn==getUsn && edtPsw == getPsw){
                    val intentToHomePage = Intent(this@Login, HomePage::class.java)
                    intentToHomePage.putExtra(Register.EXTRA_USERNAME,getUsn)
                    intentToHomePage.putExtra(Register.EXTRA_EMAIL,getEmail)
                    intentToHomePage.putExtra(Register.EXTRA_PHONE,getPhone)
                    startActivity(intentToHomePage)
                }else{
                    Toast.makeText(this@Login,"Username atau Password yang kamu masukkan salah", Toast.LENGTH_SHORT).show()
                }
            }
            register.setOnClickListener{
                val intentToRegister = Intent(this@Login, Register::class.java)
                startActivity(intentToRegister)
            }
        }

    }
}