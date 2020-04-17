package com.douglasborba.nybooks.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Idealmente a instancia do retrofit deve ser um singleton para não ser chamado toda vez que fosse usado
// por isso tornando a classe num object já temos esse singleton
object ApiService {

    private fun initRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    //Vincula o retrofit a classe que contem os endpoint da api
    val service: NYTServices = initRetrofit().create(NYTServices::class.java)
}