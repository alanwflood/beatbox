package com.example.beatbox

import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {
    private lateinit var soundLoader: SoundLoader
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        soundLoader = mock(SoundLoader::class.java)
        sound = Sound("assetPath", 1)
        subject = SoundViewModel(soundLoader)
        subject.sound = sound
    }

    @Test
    fun onClick() {
        subject.onClick()
        verify(soundLoader).play(sound)
    }

    @Test
    fun getTitle() {
        assertThat(subject.title, `is`(sound.name))
    }

    @Test
    fun getSound() {
        assertThat(subject.sound, `is`(sound))
    }

    @Test
    fun setSound() {
        sound = Sound("anotherSound", 2)
        subject.sound = sound
        assertThat(subject.sound, `is`(sound))
    }
}