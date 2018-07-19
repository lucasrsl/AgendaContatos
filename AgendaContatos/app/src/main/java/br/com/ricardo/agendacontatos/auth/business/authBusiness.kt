package br.com.ricardo.agendacontatos.auth.business

import br.com.ricardo.agendacontatos.auth.database.authDatabase
import br.com.ricardo.agendacontatos.auth.modules.Data
import br.com.ricardo.agendacontatos.auth.network.authNetwork

object authBusiness {
    fun buscaPerfil(email: String, senha: String, onSuccess: () -> Unit, onError: () -> Unit){
        authNetwork.login(email,senha,{ data: Data ->
            authDatabase.salvaPerfil(data.data){
                onSuccess()
            }
        },{
            onError()
        })
    }

    fun criaConta(email: String, senha: String, onSuccess: () -> Unit, onError: () -> Unit){

    }

}