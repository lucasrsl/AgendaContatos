package br.com.ricardo.agendacontatos.contatos.network

import br.com.ricardo.agendacontatos.auth.modules.User
import br.com.ricardo.agendacontatos.contatos.modules.Contact
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface contatosAPI {

    @GET("/contacts")
    fun listarContatos(@Header ("uid") uid: String, @Header ("client") client: String, @Header ("access-token") accessToken: String) : Observable<List<Contact>>

}