package com.alirizakaygusuz.ahtapot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import com.alirizakaygusuz.ahtapot.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

       initalizeSplashAnimation()


    }

    private fun initalizeSplashAnimation() {
       val ahtapotAnimation = AnimationUtils.loadAnimation(this , R.anim.ahtapot_splash_anim)
       val textSplashAnim = AnimationUtils.loadAnimation(this , R.anim.text_splash_anim)

        binding.imvAhtapotSplash.animation = ahtapotAnimation
        binding.txtAppNameSplash.animation = textSplashAnim


        window.statusBarColor = resources.getColor(R.color.color_default)

    }

    override fun onResume() {
        object : CountDownTimer(4000, 1000) {
            override fun onTick(p0: Long) {


            }

            override fun onFinish() {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }

        }.start()
        super.onResume()

    }
}