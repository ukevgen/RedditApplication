package com.example.reddit.domain.usecase

import com.example.reddit.data.repository.AuthRepository
import com.example.reddit.domain.usecase.base.AbsUseCaseCompl
import io.reactivex.Completable
import javax.inject.Inject

class UpdateTokenUseCase @Inject constructor(private val authRepository: AuthRepository) : AbsUseCaseCompl<Unit>() {

    override fun buildUseCaseObservable(params: Unit): Completable {
        return authRepository.updateToken()
    }
}