package com.example.data.repository.remote.datasourceImpl

import com.example.data.remote.api.LoveCalculatorApi
import com.example.data.remote.model.DataLoveResponse
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.utils.base.BaseDataSource
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi
) : BaseDataSource(), MainDataSource {
    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sname: String,
        fname: String
    ): DataLoveResponse? {
        return safeApiCall(remoteErrorEmitter){
            loveCalculatorApi.getPercentage(host = host, key = key, sname = sname, fname = fname)
        }?.body()
    }
}