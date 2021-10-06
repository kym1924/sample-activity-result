package com.activity.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.activity.result.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setBtnMoveToMainClickListener()
    }

    private fun setBtnMoveToMainClickListener() {
        binding.btnMoveToMain.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra("result", "SampleActivityResult"))
            finish()
        }
    }
}
