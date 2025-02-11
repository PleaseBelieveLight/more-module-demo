package com.yyzy.main.core.testing.repo

import com.yyzy.data.repo.TrackRepository
import com.yyzy.database.model.LifeTrackEntity
import com.yyzy.model.ClassAndGradle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @Author: ljl
 * @Email: ljl@dofun.cc
 * @ClassName: com.yyzy.main.core.testing.repo
 * @Description: 这里注入测试数据
 * @Date: 2024/4/18
 */
class TestLifeTrackRepository @Inject constructor() : TrackRepository {

    override fun getLifeTrackFlow(): Flow<List<LifeTrackEntity>> {
        val elements = LifeTrackEntity(
            id = "1001",
            like = "testing",
            type = "testing",
            character = "t",
            lifeTrack = arrayListOf("testing"),
            classGradle = ClassAndGradle.TIE_TANG,
        )
        return flow { emit(arrayListOf(elements)) }
    }

    override suspend fun saveLifeTrackEntity(lifeTrack: LifeTrackEntity) {}
}