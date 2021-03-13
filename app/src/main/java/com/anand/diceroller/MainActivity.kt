package com.anand.diceroller

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice.addAnimatorListener(object : Animator.AnimatorListener{

            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                hideDice()
                val random=(1..6).random()
                numbersView_txt.text=random.toString()
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }

        })


    }

    private fun showDice(){
        dice.visibility=View.VISIBLE
        numbersView_txt.visibility=View.GONE
        roll_dice_btn.isEnabled=false
    }

    private fun hideDice(){
        dice.visibility=View.GONE
        numbersView_txt.visibility=View.VISIBLE
        roll_dice_btn.isEnabled=true
    }

    fun onButtenClicked(view: View) {
        showDice()
        dice.playAnimation()
    }
}