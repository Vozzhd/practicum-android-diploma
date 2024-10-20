package ru.practicum.android.diploma.search.data.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.practicum.android.diploma.search.data.converters.SearchVacancyNetworkConverter
import ru.practicum.android.diploma.search.data.network.VacancySearchRequest
import ru.practicum.android.diploma.search.data.network.VacancySearchResponse
import ru.practicum.android.diploma.search.domain.api.SearchVacancyRepository
import ru.practicum.android.diploma.search.domain.models.VacancyListResponseData
import ru.practicum.android.diploma.util.Resource
import ru.practicum.android.diploma.util.network.HttpStatusCode
import ru.practicum.android.diploma.util.network.NetworkClient

class SearchVacancyRepositoryImpl(
    private val networkClient: NetworkClient,
    private val converter: SearchVacancyNetworkConverter
) : SearchVacancyRepository {

    override fun getVacancyList(query: HashMap<String, String>): Flow<Resource<VacancyListResponseData>> = flow {
        val response = networkClient.doRequest(VacancySearchRequest(query))
        emit(
            when (response.resultCode) {
                HttpStatusCode.OK -> Resource.Success(
                    converter.map(response as VacancySearchResponse)
                )
                else -> Resource.Error(response.resultCode)
            }
        )
    }
}
