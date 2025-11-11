package com.kushy.arcadia.dto

class ResponseDTO (
    val nome: String,
    val token: String? = null,
    val type: String = "Bearer"
){
}