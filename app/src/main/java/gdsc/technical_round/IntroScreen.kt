package gdsc.technical_round

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import gdsc.technical_round.databinding.ActivityIntroScreenBinding

class IntroScreen : AppCompatActivity() {
    private lateinit var binding: ActivityIntroScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerfl.setOnClickListener {
            val intent = Intent(this@IntroScreen, SignUpActivity::class.java)
            startActivity(intent)

        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
        }

        binding.signinfl.setOnClickListener {
            val intent = Intent(this@IntroScreen, SignInActivity::class.java)
            startActivity(intent)

        }
    }
}