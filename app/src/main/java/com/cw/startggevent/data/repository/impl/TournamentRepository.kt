package com.cw.startggevent.data.repository.impl

import com.apollographql.apollo.ApolloClient
import com.cw.startggevent.data.model.TournamentsByCountryQuery
import com.cw.startggevent.data.repository.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TournamentRepository @Inject constructor(private val apolloClient: ApolloClient) :
    BaseRepository {

    fun getTournamentsByCountry(cCode: String, perPage: Int) =
        apolloClient.query(TournamentsByCountryQuery(cCode = cCode, perPage = perPage)).toFlow()
}