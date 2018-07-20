package br.com.ricardo.agendacontatos.auth.network

import br.com.ricardo.agendacontatos.auth.modules.Data
import br.com.ricardo.agendacontatos.auth.modules.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object authNetwork {

    val authAPI by lazy {
        getRetrofit().create(authAPI::class.java)
    }

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
                .baseUrl("https://api-agenda-unifor.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun login(user: User, onSuccess: (user: User) -> Unit, onError: () -> Unit){


        authAPI.login(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    val userResponse = data.body()?.data

                    userResponse?.let {
                        it.uid = data.headers()["Uid"]
                        it.accessToken = data.headers()["Access-Token"]
                        it.client = data.headers()["Client"]
                        onSuccess(it)
                    }

                },{
                    onError()
                })
    }

    fun criarUsuario(user: User, onSuccess: (msg: String) -> Unit,  onError: () -> Unit){
        authAPI.criaUsuario(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess("Usuário criado com sucesso!")
                    it
                },{
                   onError()
                })

    }
}