package com.example.domain.repository

import com.example.domain.model.DomainLoveResponse
import com.example.domain.utils.RemoteErrorEmitter

interface MainRepository {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sname: String,
        fname: String
    ): DomainLoveResponse?
}