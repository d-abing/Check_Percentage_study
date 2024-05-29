package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataLoveResponse
import com.example.domain.utils.RemoteErrorEmitter

interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sname: String,
        fname: String,
    ): DataLoveResponse?
}