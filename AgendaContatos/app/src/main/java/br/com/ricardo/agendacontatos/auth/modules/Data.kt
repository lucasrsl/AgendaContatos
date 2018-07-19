package br.com.ricardo.agendacontatos.auth.modules

import io.realm.RealmObject

open class Data: RealmObject() {

    var data: User? = null
}