package com.github.tumusx.present

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.github.tumusx.databinding.ActivityMainBinding
import com.github.tumusx.model.CepModel
import com.github.tumusx.present.viewModel.CepViewModel

class SearchCEPActivity : AppCompatActivity() {
    private lateinit var viewModel: CepViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CepViewModel::class.java)
        viewModel.onResultRequest.observe(this, this::configureResult)
        binding.viewModel = viewModel
        setContentView(binding.root)
        configureObservables()
    }

    private fun configureObservables(){
        binding.button.setOnClickListener {
            viewModel.getServiceCEP(this@SearchCEPActivity)
        }
    }

    private fun configureResult(isError: Boolean) {
        if(!isError){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

}