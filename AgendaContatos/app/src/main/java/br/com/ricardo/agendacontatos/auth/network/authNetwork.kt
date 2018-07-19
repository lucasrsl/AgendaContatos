package br.com.ricardo.agendacontatos.auth.network

import br.com.ricardo.agendacontatos.auth.modules.Data
import br.com.ricardo.agendacontatos.auth.modules.User
import io.reactivex.Scheduler
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

    fun login(email: String, senha: String, onSuccess: (data: Data) -> Unit, onError: () -> Unit){

        var user = User()
        user.email = email
        user.senha = senha

        authAPI.login(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers
                .mainThread())
                .subscribe({ data ->

                    data?.let{
                        onSuccess(it)
                    }
                },{
                    onError()
                })
    }

    fun criarUsuario(email: String, senha: String, onSuccess: (data: Data) -> Unit, onError: () -> Unit){
        var user = User()
        user.email = email
        user.senha = senha


    }
}