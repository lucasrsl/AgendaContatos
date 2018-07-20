package br.com.ricardo.agendacontatos.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.ricardo.agendacontatos.R
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.design.widget.Snackbar
import br.com.ricardo.agendacontatos.auth.business.authBusiness
import br.com.ricardo.agendacontatos.auth.modules.User
import io.realm.Realm


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)

        configuraBotaoEntrar()
        configuraBoraoCriar()
    }

    private fun configuraBoraoCriar() {
        botaoCriar.setOnClickListener {
            var user = User()
            user.email = campoEmail.text.toString()
            user.password = campoSenha.text.toString()
            user.password_confirmation = user.password

            authBusiness.criaConta(user, {

                Snackbar.make(botaoCriar, it, Snackbar.LENGTH_SHORT).show()
            },{

                Snackbar.make(botaoCriar, it, Snackbar.LENGTH_SHORT).show()
            })
        }
    }

    private fun configuraBotaoEntrar() {

        botaoEntrar.setOnClickListener{
            var user = User()
            user.email = campoEmail.text.toString()
            user.password = campoSenha.text.toString()

            authBusiness.fazLogin(user, {

                val intent = Intent(this, ContatosActivity::class.java)
                startActivity(intent)
            }, {

                Snackbar.make(botaoEntrar, it, Snackbar.LENGTH_SHORT).show()
            })
        }
    }
}
