package app.lws.frameworkJar.demo

import android.app.Activity
import android.os.Bundle
import androidx.core.content.ContextCompat


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ContextCompat.getDataDir(this)
    }
}