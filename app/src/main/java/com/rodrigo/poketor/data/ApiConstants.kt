package com.rodrigo.poketor.data

object ApiConstants {
    const val SETS_SELECT = "id,name,series,releaseDate,images"
    const val SETS_ORDER = "-releaseDate,series"
    const val CARDS_SELECT = "id,name,set,number,rarity,images,tcgplayer"
}