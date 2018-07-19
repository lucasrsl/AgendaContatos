package br.com.ricardo.agendacontatos.auth.modules

import io.realm.RealmObject

open class User:RealmObject() {

    var id: Int = 0
    var email: String? = ""
    var senha: String? = ""
    var confirmaSenha: String? = ""
    var name: String? = ""
    var nickname: String? = ""
    var image: String? = ""

}
