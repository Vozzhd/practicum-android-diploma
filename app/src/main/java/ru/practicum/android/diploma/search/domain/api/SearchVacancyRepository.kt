package ru.practicum.android.diploma.search.domain.api

import kotlinx.coroutines.flow.Flow
import ru.practicum.android.diploma.search.domain.models.VacancySearch
import ru.practicum.android.diploma.util.Resource

interface SearchVacancyRepository {

    fun getVacancyList(
        page: Int = 0,
        text: String,
        industry: String? = null,
        salary: Int? = null,
        onlyWithSalary: Boolean = false
    ): Flow<Resource<List<VacancySearch>>>
}