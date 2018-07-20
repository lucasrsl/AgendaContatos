package br.com.ricardo.agendacontatos.auth.business

import br.com.ricardo.agendacontatos.auth.database.authDatabase
import br.com.ricardo.agendacontatos.auth.modules.User
import br.com.ricardo.agendacontatos.auth.network.authNetwork

object authBusiness {
    fun fazLogin(user: User, onSuccess: () -> Unit, onError: (msg: String) -> Unit){
        authNetwork.login(user,{ response: User ->

            response?.let {
                authDatabase.limpaBanco()
                authDatabase.salvaPerfil(it){
                    onSuccess()
                }

            }
        },{
            onError("Conta não encontrada!")
        })
    }

    fun criaConta(user: User, onSuccess: (msg: String) -> Unit, onError: (msg: String) -> Unit){
        authNetwork.criarUsuario(user,{
            onSuccess(it)
        },{
            onError("E-mail já está cadastrado!")
        })

    }

}