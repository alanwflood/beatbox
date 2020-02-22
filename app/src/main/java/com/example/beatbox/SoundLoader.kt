package com.example.beatbox

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.lang.Exception

private const val TAG = "SoundLoader"
private const val SOUNDS_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 5

class SoundLoader(private val assets: AssetManager) {
    val sounds: List<Sound>
    private val soundPool: SoundPool = SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build()

    init {
        sounds = loadSounds()
    }

    fun play(sound: Sound) {
        soundPool.play(
            sound.soundId,
            1.0f,
            1.0f,
            1,
            0,
            1.0f
        )
    }

    fun release() {
        soundPool.release()
    }

    private fun loadSounds(): List<Sound> {
        return try {
            val soundNames = assets.list(SOUNDS_FOLDER)!!
            Log.d(TAG, "Found ${soundNames.size} sounds")
            soundNames.map { filename ->
                val assetPath = "$SOUNDS_FOLDER/$filename"
                val afd: AssetFileDescriptor = assets.openFd(assetPath)
                val soundId = soundPool.load(afd, 1)
                Log.d(TAG, "Sound: $assetPath")
                Sound(assetPath, soundId)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Could not list assets", e)
            emptyList()
        }
    }
}

class Sound(assetPath: String, val soundId: Int) {
    val name = assetPath.split("/").last().let {
        val extensionIndex = it.lastIndexOf('.')
        if (extensionIndex != -1) {
            it.substring(0, extensionIndex)
        } else {
            it
        }
    }
}