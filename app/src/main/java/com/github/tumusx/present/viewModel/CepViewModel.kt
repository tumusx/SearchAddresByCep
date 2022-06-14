package com.github.tumusx.present.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.tumusx.data.RetrofitInit
import com.github.tumusx.model.CepModel
import retrofit2.Response

class CepViewModel: ViewModel(){
    val onResultRequest = MutableLiveData<Boolean>()
    val cepInputText = ObservableField<String>()
    val cepInformation = ObservableField<String>()

    fun getServiceCEP(context: Context){
        val onInitRetrofit = RetrofitInit.cepRepository.onGetServer(cepInputText.get().toString())
        onInitRetrofit.enqueue(object: retrofit2.Callback<CepModel>{
           override fun onResponse(call: retrofit2.Call<CepModel>, response: Response<CepModel>) {
               onResultRequest.postValue(true)
               Log.d("response: ", response.body().toString())
               cepInformation.set(response.body().toString())
           }

           override fun onFailure(call: retrofit2.Call<CepModel>, t: Throwable) {
               Toast.makeText(context, "Incorrect CEP or empty field", Toast.LENGTH_SHORT).show()
               onResultRequest.postValue(false)
           }
       })
    }
}