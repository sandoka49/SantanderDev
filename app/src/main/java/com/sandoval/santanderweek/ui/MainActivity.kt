package com.sandoval.santanderweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sandoval.santanderweek.R
import com.sandoval.santanderweek.R.id.*
import com.sandoval.santanderweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta : Conta) {
        findViewById<TextView>(tv_agencia).text = conta.agencia
        findViewById<TextView>(tv_conta_corrente).text = conta.numero
        findViewById<TextView>(tv_saldo).text = conta.saldo
        findViewById<TextView>(tv_limite).text = conta.limite
        findViewById<TextView>(tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(tv_cartao_final_value).text = conta.cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.mein_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("CLICK1", "Click no Item 1")
                true
            }
            R.id.item_2 -> {
                Log.d("CLICK2", "Click no Item 2")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

  }

}