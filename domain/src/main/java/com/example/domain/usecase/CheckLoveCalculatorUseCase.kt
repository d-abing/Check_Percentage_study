package com.example.domain.usecase

import com.example.domain.repository.MainRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class CheckLoveCalculatorUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun execute(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        sname: String,
        fname: String
    ) = mainRepository.checkLoveCalculator(remoteErrorEmitter, host, key, sname, fname)
}