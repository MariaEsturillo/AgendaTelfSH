package com.example.agendatelfsh

import android.widget.Toast

import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgendaTlfSH(modifier: Modifier){

    val contactos :Map<String, List<Contacto>> = getContactos().groupBy { it.inicial }
    LazyColumn (modifier = modifier.fillMaxSize().background(Color.White)){
        contactos.forEach{
            (inicial, contactos) ->
            stickyHeader {
                Text(inicial,modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF246d73)),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
            items(contactos){ contacto ->
                ItemContacto(contacto){selectedContacto ->
                    println("Contacto seleccionado: ${selectedContacto.nombre}")
                }

            }
        }
    }

}

@Composable
fun ItemContacto(contacto: Contacto, onItemSelected :(Contacto) -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth()
            .clickable {
                try {
                    onItemSelected(contacto)

                    Toast.makeText(context, contacto.numero.toString(), Toast.LENGTH_SHORT).show()
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        .background (Color.White)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)) {
            Box(modifier =Modifier
                .size(50.dp)
                .background(randomColor(), shape = CircleShape),
                contentAlignment = Alignment.Center ){
                Text(text = contacto.inicial,
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = contacto.nombre, modifier = Modifier.background(Color.White))

        }
    }
}



fun getContactos(): List<Contacto>{
    return listOf(
        Contacto("A","Ana Garcia",111111111),
        Contacto("B","Beatriz Barbosa",222222222),
        Contacto("C","Carlos Castro",333333333),
        Contacto("D","David Díaz",444444444),
        Contacto("E","Elena Espinoza",555555555),
        Contacto("F","Fernando Fernández",666666666),
        Contacto("G","Gloria González",777777777),
        Contacto("H","Héctor Hernández",888888888),
        Contacto("I","Isabel Iglesias",999999999),
        Contacto("J","José Jiménez",111111111),
        Contacto("K","Kevin Koval",222222222),
        Contacto("L","Laura López",333333333),
        Contacto("M","Manuel Martínez",444444444),
        Contacto("N","Natalia Navarro",555555555),
        Contacto("O","Olga Ortiz",666666666),
        Contacto("P","Pedro Pérez",777777777),
        Contacto("Q","Quim Quesada",888888888),
        Contacto("R","Raúl Rodríguez",999999999),
        Contacto("S","Sofía Sánchez",111111111),
        Contacto("T","Teresa Torres",222222222),
        Contacto("U","Ursula Uribe",333333333),
        Contacto("V","Víctor Velázquez",444444444),
        Contacto("W","Walter Wenzel",555555555),
        Contacto("X","Ximena Xavier",666666666),
        Contacto("Y","Yolanda Yáñez",777777777),
        Contacto("Z","Zacarías Zúñiga",888888888),
)

}

fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1.0f
    )
}