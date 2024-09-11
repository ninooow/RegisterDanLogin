package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    companion object{
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnRegister.setOnClickListener{
                val username = txtUsn.text.toString()
                val email = txtEmail.text.toString()
                val phone = txtPhone.text.toString()
                val password = txtPsw.text.toString()
                if(username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && termsAndCondition.isChecked) {
                    val intentToLogin = Intent(this@Register, Login::class.java)
                    intentToLogin.putExtra(EXTRA_USERNAME, username)
                    intentToLogin.putExtra(EXTRA_EMAIL, email)
                    intentToLogin.putExtra(EXTRA_PHONE, phone)
                    intentToLogin.putExtra(EXTRA_PASSWORD, password)
                    startActivity(intentToLogin)
                }else{
                    Toast.makeText(this@Register, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
                }
            }
            login.setOnClickListener{
                val intentToLogin = Intent(this@Register, Login::class.java)
                startActivity(intentToLogin)
            }

        }
    }
}