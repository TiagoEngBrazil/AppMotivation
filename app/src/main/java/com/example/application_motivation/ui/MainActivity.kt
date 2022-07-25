package com.example.application_motivation.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.application_motivation.infra.MotivationConstants
import com.example.application_motivation.R
import com.example.application_motivation.R.id
import com.example.application_motivation.data.Mock
import com.example.application_motivation.databinding.ActivityMainBinding
import com.example.application_motivation.infra.securityPreferences
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.filter.all

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        handleFilter(id.image_all)
        handleNextPhrase()


        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageEmotions.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.textHiKotlin.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        handleUserName()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onClick(view: View) {
        if (view.id == id.button_newPhrase) {
            handleNextPhrase()
        } else if (view.id in listOf(id.image_all, id.image_emotions, id.image_sunny) ) {
            handleFilter(view.id)
        } else if (view.id == id.text_Hi_kotlin) {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun handleNextPhrase() {

        binding.textCenterText.text = Mock().getFrases(categoryId, Locale.getDefault().language)
    }

    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.purple_700))
        binding.imageEmotions.setColorFilter(ContextCompat.getColor(this, R.color.purple_700))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.purple_700))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.filter.all
            }
            R.id.image_emotions -> {
                binding.imageEmotions.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.filter.emotions
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.filter.sunny
            }
        }
    }

    private fun handleUserName() {
        val name = securityPreferences(this).getString(MotivationConstants.Key.User_Name)
        binding.textHiKotlin.text = "Olá, $name!"
    }
}