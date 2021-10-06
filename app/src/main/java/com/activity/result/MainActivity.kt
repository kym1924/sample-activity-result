package com.activity.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.activity.result.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainActivityResult = registerForActivityResult(
        StartActivityForResult()
    ) { activityResult ->
        showSnackBar(activityResult)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setBtnMoveToSecondClickListener()
    }

    private fun setBtnMoveToSecondClickListener() {
        binding.btnMoveToSecond.setOnClickListener {
            mainActivityResult.launch(Intent(this, SecondActivity::class.java))
        }
    }

    private fun showSnackBar(activityResult: ActivityResult) {
        if (activityResult.resultCode == RESULT_OK) {
            activityResult.data?.getStringExtra("result")?.let {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}