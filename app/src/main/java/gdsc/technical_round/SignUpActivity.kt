package gdsc.technical_round

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import gdsc.technical_round.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener{
            val email = binding.edtEmailSignUp.text.toString()
            val password = binding.edtPasswordSignUp.text.toString()

            signUp(email, password)

        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
        }

        binding.edtNameSignUp.setOnClickListener { startElevationAnimation(binding.edtNameSignUp) }
        binding.edtEmailSignUp.setOnClickListener { startElevationAnimation(binding.edtEmailSignUp) }
        binding.edtPasswordSignUp.setOnClickListener { startElevationAnimation(binding.edtPasswordSignUp) }

        binding.SignInSignUpbtn.setOnClickListener {
            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task ->
                if(task.isSuccessful){
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@SignUpActivity, "Some error occured", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun startElevationAnimation(view: View) {
        val animatorSet = AnimatorInflater.loadAnimator(this, R.animator.elevation_change) as AnimatorSet
        animatorSet.setTarget(view)
        animatorSet.start()
    }
}