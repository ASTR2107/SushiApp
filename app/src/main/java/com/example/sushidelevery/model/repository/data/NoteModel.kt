package com.example.sushidelevery.model.repository.data

import android.icu.text.CaseMap.Title
import java.net.IDN
import java.time.LocalDate

data class NoteModel(
    val idn: String,
    val title: String,
    val subtitle: String,
    val data: String,
    val author: String
)
