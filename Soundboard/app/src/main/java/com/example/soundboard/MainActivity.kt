package com.example.soundboard

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.soundboard.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var soundPool: SoundPool

    private var kickSoundId: Int = 0
    private var snareSoundId: Int = 0
    private var clapSoundId: Int = 0
    private var hiHatSoundId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build()
            soundPool = SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(6)
                .build()
        } else {
            soundPool = SoundPool(6, AudioManager.USE_DEFAULT_STREAM_TYPE, 0)
        }

        kickSoundId = soundPool.load(this, R.raw.kick, 1)
        snareSoundId = soundPool.load(this, R.raw.snare, 1)
        clapSoundId = soundPool.load(this, R.raw.clap, 1)
        hiHatSoundId = soundPool.load(this, R.raw.hihat, 1)



        binding.ibKick.setOnClickListener { playKick() }
        binding.ibSnare.setOnClickListener{playSnare()}
        binding.ibClap.setOnClickListener{playClap()}
        binding.ibHihat.setOnClickListener{playHiHat()}
    }


    fun playKick() {
        soundPool.play(kickSoundId, 1f, 1f, 1, 0, 1f)
    }

    fun playSnare() {
        soundPool.play(snareSoundId, 1f, 1f, 1, 0, 1f)
    }

    fun playClap() {
        soundPool.play(clapSoundId, 1f, 1f, 1, 0, 1f)
    }

    fun playHiHat() {
        soundPool.play(hiHatSoundId, 1f, 1f, 1, 0, 1f)
    }
}