package br.com.ricardo.agendacontatos.auth.modules

import io.realm.RealmObject

open class User:RealmObject() {

    var id: Int = 0
    var email: String? = null
    var password: String? = null
    var password_confirmation: String? = null
    var name: String? = null
    var nickname: String? = null
    var image: String? = null
    var uid: String? = null
    var accessToken: String? = null
    var client: String? = null

}
