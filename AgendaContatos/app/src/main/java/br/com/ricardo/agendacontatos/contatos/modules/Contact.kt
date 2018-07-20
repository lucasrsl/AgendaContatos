package br.com.ricardo.agendacontatos.contatos.modules

import io.realm.RealmObject

class Contact: RealmObject() {
    var id: Int = 0
    var name: String? = null
    var email: String? = null
    var phone: String? = null
    var picture: String? = null
    var birth: Int = 0
}