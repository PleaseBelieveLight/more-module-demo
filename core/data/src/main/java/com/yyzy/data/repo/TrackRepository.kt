package com.yyzy.data.repo

import com.yyzy.database.model.LifeTrackEntity
import kotlinx.coroutines.flow.Flow


/**
 * @Author: ljl
 * @Email: ljl@dofun.cc
 * @ClassName: com.yyzy.data.repo
 * @Description: 为了添加更多的数据源
 * @Date: 2024/4/18
 */
interface TrackRepository {

    fun getLifeTrackFlow(): Flow<List<LifeTrackEntity>>

    suspend fun saveLifeTrackEntity(lifeTrack: LifeTrackEntity)

    suspend fun saveLifeTrackEntity() = Unit
}