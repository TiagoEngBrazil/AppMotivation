package com.example.application_motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.application_motivation.infra.MotivationConstants
import com.example.application_motivation.R
import com.example.application_motivation.databinding.ActivityUserBinding
import com.example.application_motivation.infra.securityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        supportActionBar?.hide()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun handleSave() {

        val name = binding.textName.text.toString()
        if (name != "") {

            securityPreferences(this).storeString(MotivationConstants.Key.User_Name, name)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_LONG).show()
        }
    }
}