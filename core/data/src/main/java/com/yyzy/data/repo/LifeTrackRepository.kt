package com.yyzy.data.repo

import com.yyzy.database.dao.LifeTrackDAO
import com.yyzy.database.model.LifeTrackEntity
import com.yyzy.model.ClassAndGradle
import javax.inject.Inject

/**
 * @Author: ljl
 * @Email: ljl@dofun.cc
 * @ClassName: com.yyzy.data.repo
 * @Description: CODE
 * @Date: 2024/2/1
 */
class LifeTrackRepository @Inject constructor(
    private val lifeTrackDAO: LifeTrackDAO
) : TrackRepository {

    override fun getLifeTrackFlow() = lifeTrackDAO.searchAllLifeTrackEntity()

    override suspend fun saveLifeTrackEntity() {
        lifeTrackDAO.insert(defalutLifeTrackEntity())
    }

    override suspend fun saveLifeTrackEntity(lifeTrack: LifeTrackEntity) {
        lifeTrackDAO.insert(lifeTrack)
    }

    private fun defalutLifeTrackEntity(): LifeTrackEntity {
        return LifeTrackEntity(
            id = "10000",
            like = "dog",
            type = "anim",
            character = "d",
            lifeTrack = arrayListOf("eat"),
            classGradle = ClassAndGradle.TIE_TANG,
        )
    }
}