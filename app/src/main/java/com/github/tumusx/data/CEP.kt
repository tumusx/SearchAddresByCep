package com.github.tumusx.data

import com.github.tumusx.model.CepModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CEP {

    @GET("{CEP}/json")
     fun onGetServer(@Path("CEP") byCEP: String): retrofit2.Call<CepModel>
}