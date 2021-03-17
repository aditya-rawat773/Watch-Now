package com.example.movieapp.ui.Single_Movie_Detail

import androidx.lifecycle.LiveData
import com.example.movieapp.data.api.MovieDBInterface
import com.example.movieapp.data.repository.MovieDetailsNetworkDataSource
import com.example.movieapp.data.repository.NetworkState
import com.example.movieapp.data.vo.MovieData
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : MovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieData> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}