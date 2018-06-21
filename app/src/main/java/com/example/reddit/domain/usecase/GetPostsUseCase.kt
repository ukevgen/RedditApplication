package com.example.reddit.domain.usecase

import com.example.reddit.domain.model.PostData
import com.example.reddit.domain.repository.RedditDataRepository
import com.example.reddit.domain.usecase.base.AbsUseCaseSingle
import io.reactivex.Single
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(val updateTokenUseCase: UpdateTokenUseCase,
                                          val redditDataRepository: RedditDataRepository) : AbsUseCaseSingle<PostData, GetPostsUseCase.Params>() {

    override fun buildUseCaseObservable(params: Params): Single<PostData> {
        return updateTokenUseCase.buildUseCaseObservable(Unit)
                .andThen(
                        redditDataRepository.getPosts(params.afterPostKey)
                )
    }

    class Params(val afterPostKey: String = "")
}