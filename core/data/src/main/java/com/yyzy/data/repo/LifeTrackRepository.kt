package com.yyzy.data.repo
import com.yyzy.database.dao.LifeTrackDAO
import com.yyzy.database.model.LifeTrackEntity
import com.yyzy.model.ClassAndGradle
import javax.inject.Inject

/**
 * @Author: ljl
 * @Email: ljl@dofun.cc
 * @ClassName: com.yyzy.data.repo
 * @Description: LifeTrackRepository
 * @Date: 2024/2/1
 */
class LifeTrackRepository @Inject constructor(
    private val lifeTrackDAO: LifeTrackDAO
) {
    fun getLifeTrackFlow() = lifeTrackDAO.searchAllLifeTrackEntity()

    suspend fun saveLifeTrackEntity(lifeTrack: LifeTrackEntity = defalutLifeTrackEntity()) {
        lifeTrackDAO.insert(lifeTrack)
    }

    private fun defalutLifeTrackEntity(): LifeTrackEntity {
        return LifeTrackEntity(
            id = "444",
            like = "la",
            type = "ji",
            character = "a",
            lifeTrack = arrayListOf("pig school"),
            classGradle = ClassAndGradle.TIE_TANG,
        )
    }
}