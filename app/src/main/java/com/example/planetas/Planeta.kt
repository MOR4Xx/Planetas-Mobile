package com.example.planetas

import kotlin.collections.listOf

data class Planeta(val nome: String, val imagem: Int)

object PlanetaData {
    fun getPlanetas(): List<Planeta> {
        return listOf(
            Planeta("Mercúrio", R.drawable.planeta_01_mercurio),
            Planeta("Vênus", R.drawable.planeta_02_venus),
            Planeta("Terra", R.drawable.planeta_03_terra),
            Planeta("Marte", R.drawable.planeta_04_marte),
            Planeta("Júpiter", R.drawable.planeta_05_jupiter),
            Planeta("Saturno", R.drawable.planeta_06_saturno),
            Planeta("Urano", R.drawable.planeta_07_urano),
            Planeta("Netuno", R.drawable.planeta_08_neptuno),
            Planeta("Plutão", R.drawable.planeta_09_plutao)
        )
    }
}
