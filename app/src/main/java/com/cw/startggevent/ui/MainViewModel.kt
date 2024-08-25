package com.cw.startggevent.ui

import androidx.lifecycle.ViewModel
import com.cw.startggevent.data.repository.impl.TournamentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: TournamentRepository) :
    ViewModel() {

}
