package com.example.beatbox

import androidx.databinding.BaseObservable

class SoundViewModel(private val soundLoader: SoundLoader): BaseObservable() {
    fun onClick() {
        sound?.let {
            soundLoader.play(it)
        }
    }

    val title: String?
        get() = sound?.name

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }
}