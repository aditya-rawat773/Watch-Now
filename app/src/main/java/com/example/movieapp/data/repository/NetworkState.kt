package com.example.movieapp.data.repository

enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}
class NetworkState(val status: Status, val msg:String) {
    companion object{

        val loaded:NetworkState = NetworkState(Status.SUCCESS , msg = "Success")
        val loading:NetworkState = NetworkState(Status.RUNNING , msg = "Running")
        val error:NetworkState = NetworkState(Status.FAILED , msg = "Something went wrong")
        val ENDOFLIST:NetworkState = NetworkState(Status.FAILED, msg = "You have reached the end")

    }
}