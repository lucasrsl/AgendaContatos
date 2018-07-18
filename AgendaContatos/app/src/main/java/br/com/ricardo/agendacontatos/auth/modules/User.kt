package br.com.ricardo.agendacontatos.auth.modules

import io.realm.RealmObject

open class User:RealmObject() {

    var email: String? = ""

}
