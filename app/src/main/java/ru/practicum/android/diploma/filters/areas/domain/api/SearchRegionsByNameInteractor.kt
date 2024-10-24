package ru.practicum.android.diploma.filters.areas.domain.api

import kotlinx.coroutines.flow.Flow
import ru.practicum.android.diploma.filters.areas.domain.models.Area
import ru.practicum.android.diploma.util.network.HttpStatusCode

interface SearchRegionsByNameInteractor {
    fun setText(text: String)
    fun setParentId(parentId: String)
    fun searchRegionsByName(): Flow<Pair<List<Area>?, HttpStatusCode?>>
}
