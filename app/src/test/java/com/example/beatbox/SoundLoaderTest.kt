package com.example.beatbox

import android.content.Context
import android.media.SoundPool
import org.hamcrest.CoreMatchers.hasItems
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito.`when`

private const val MOCK_SOUND_FOLDER = "A Folder of sounds"
private val SOUND_FILES = listOf("sound.wav", "sound.WAV", "sound.mp3").toTypedArray()

class SoundLoaderTest {
    @Mock
    private lateinit var context: Context
    private lateinit var subject: SoundLoader

    @Before
    fun setUp() {
        `when`(context.assets.list(MOCK_SOUND_FOLDER)).thenReturn(
            SOUND_FILES
        )
    }

    @Test
    fun getSounds() {
    }

    @Test
    fun play() {
    }

    @Test
    fun release() {
    }
}