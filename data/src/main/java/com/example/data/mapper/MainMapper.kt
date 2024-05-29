package com.example.data.mapper

import com.example.data.remote.model.DataLoveResponse
import com.example.domain.model.DomainLoveResponse

object MainMapper  {

    fun loveMapper(
        dataResponse: DataLoveResponse?
    ): DomainLoveResponse? {
        return if(dataResponse != null) {
            DomainLoveResponse(
                fname = dataResponse.fname,
                percentage = dataResponse.percentage,
                result = dataResponse.result,
                sname = dataResponse.sname
            )
        } else dataResponse
    }
}