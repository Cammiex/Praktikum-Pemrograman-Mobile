package com.example.dicerole

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        //Melakukan Roll Dadu saat aplikasi dibuka
        rollDice()
    }

    // Fungsi untuk melakukan roll dadu dan menampilkannya pada aplikasi dengan berupa gambar
    private fun rollDice() {
        // Membuat Objek dadu baru dengan 6 sisi dan melakukan roll dadu
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Menemukan Objek ImageView dalam layout menggunakan resource ID
        val diceImage: ImageView = findViewById(R.id.imageView)

        /* Menentukan hasil roll dadu yang awalnya berupa integer dan menyesuaikannya
        menjadi gambar menggunakan pengkondisian when*/
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Mengupdate Objek ImageView sesuai dengan hasil roll dadu
        diceImage.setImageResource(drawableResource)

        // Mengupdate deskripsi konten
        diceImage.contentDescription = diceRoll.toString()
    }
}

/* Membuat dadu dengan sisi dadu yang fix */
class Dice(private val numSides: Int) {

    // Melakukan roll dadu dan mengembalikan hasilnya
    fun roll(): Int {
        return (1..numSides).random()
    }
}

