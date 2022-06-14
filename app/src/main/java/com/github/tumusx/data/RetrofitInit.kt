package com.github.tumusx.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInit {

       val retrofitBuilder = Retrofit.Builder()
             .baseUrl("https://viacep.com.br/ws/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()


    val cepRepository: CepRepository = retrofitBuilder.create(CepRepository::class.java)

}