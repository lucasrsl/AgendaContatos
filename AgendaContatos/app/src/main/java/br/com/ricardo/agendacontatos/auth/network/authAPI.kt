package br.com.ricardo.agendacontatos.auth.network

import br.com.ricardo.agendacontatos.auth.modules.Data
import br.com.ricardo.agendacontatos.auth.modules.User
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface authAPI {

    @POST("/auth/sign_in")
    fun login(@Body user: User) : Observable<Response<Data>>

    @POST("/auth")
    fun criaUsuario(@Body user: User) : Observable<Data>

}