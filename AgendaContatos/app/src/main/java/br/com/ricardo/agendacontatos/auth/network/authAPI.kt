package br.com.ricardo.agendacontatos.auth.network

import br.com.ricardo.agendacontatos.auth.modules.User
import retrofit2.http.Body
import retrofit2.http.POST

interface authAPI {
    @POST("/auth")
    fun login(@Body user: User)
}