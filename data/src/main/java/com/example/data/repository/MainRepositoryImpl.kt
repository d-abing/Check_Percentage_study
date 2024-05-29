package com.example.data.repository

import com.example.data.mapper.MainMapper
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.domain.model.DomainLoveResponse
import com.example.domain.repository.MainRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
) : MainRepository {
    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sname: String,
        fname: String
    ): DomainLoveResponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter, host, key, sname, fname))
    }
}