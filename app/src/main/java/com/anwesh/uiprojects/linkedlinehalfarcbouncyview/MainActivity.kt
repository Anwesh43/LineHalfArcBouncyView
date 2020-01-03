package com.anwesh.uiprojects.linkedlinehalfarcbouncyview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.linehalfarcbouncyviwew.LineHalfArcBouncyView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LineHalfArcBouncyView.create(this)
    }
}
