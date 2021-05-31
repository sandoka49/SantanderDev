package com.sandoval.santanderweek.data.local

import com.sandoval.santanderweek.data.Cartao
import com.sandoval.santanderweek.data.Cliente
import com.sandoval.santanderweek.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Davi Diaz")
        val cartao = Cartao("4525")
        return Conta(
            "761430-1",
            "7461",
            "R$ 3.444,00",
            "R$ 8.000,00",
            cliente,
            cartao
        );
    }
}