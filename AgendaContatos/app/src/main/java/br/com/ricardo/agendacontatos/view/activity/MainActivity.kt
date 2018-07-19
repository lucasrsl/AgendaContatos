package br.com.ricardo.agendacontatos.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.ricardo.agendacontatos.R
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.design.widget.Snackbar
import br.com.ricardo.agendacontatos.auth.business.authBusiness


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuraBotaoEntrar()
        configuraBoraoCriar()
    }

    private fun configuraBoraoCriar() {
        botaoCriar.setOnClickListener {

        }
    }

    private fun configuraBotaoEntrar() {
        botaoEntrar.setOnClickListener{
            authBusiness.buscaPerfil(campoEmail.text.toString(), campoSenha.text.toString(), {
                Snackbar.make(botaoEntrar, "Deu tudo certo!", Snackbar.LENGTH_SHORT).show()
//                val intent = Intent(this, ContatosActivity::class.java)
//                startActivity(intent)
            }, {
                Snackbar.make(botaoEntrar, "Deu errado!", Snackbar.LENGTH_SHORT).show()
            })
        }
    }
}
