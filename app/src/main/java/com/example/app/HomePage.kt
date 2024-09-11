package com.example.app

import android.os.Bundle
import android.text.Html
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.databinding.ActivityHomePageBinding
import com.example.app.databinding.ActivityLoginBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding : ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            val getUsn = intent.getStringExtra(Register.EXTRA_USERNAME)
            val getEmail = intent.getStringExtra(Register.EXTRA_EMAIL)
            val getPhone = intent.getStringExtra(Register.EXTRA_PHONE)
            textUsn.text =  Html.fromHtml("Welcome <font color='#525BFF'>$getUsn</font>", Html.FROM_HTML_MODE_LEGACY)
            textEmail.text = Html.fromHtml("Your <font color='#525BFF'>$getEmail</font> has been activated", Html.FROM_HTML_MODE_LEGACY)
            textPhone.text = Html.fromHtml("Your <font color='#525BFF'>$getPhone</font> has been registered", Html.FROM_HTML_MODE_LEGACY)
        }

    }
}