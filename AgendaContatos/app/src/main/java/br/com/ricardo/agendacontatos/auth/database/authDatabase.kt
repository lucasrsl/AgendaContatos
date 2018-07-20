package br.com.ricardo.agendacontatos.auth.database

import br.com.ricardo.agendacontatos.auth.modules.User
import io.realm.Realm


object authDatabase{
     fun salvaPerfil(user: User, onSuccess: () -> Unit){

         Realm.getDefaultInstance().use { realm ->
             realm.beginTransaction()
             realm.copyToRealm(user)
             realm.commitTransaction()
             onSuccess()

         }
     }

    fun limpaBanco(){
        Realm.getDefaultInstance().use { realm ->
            realm.beginTransaction()
            realm.deleteAll()
            realm.commitTransaction()

        }
    }
}