package googleCodelabs.TwoActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

private val TAG : String = SecondActivity::class.java.simpleName.toString()

//public
val EXTRA_REPLY : String = "googleCodelabs.TwoActivities.extra.REPLY"

class SecondActivity : AppCompatActivity() {

    lateinit var mReply : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG, "-------");
        Log.d(TAG, "onCreate");

        //Get the Intent that activated this Activity
        val intent: Intent = intent
        val message : String? = intent.getStringExtra(googleCodelabs.TwoActivities.EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }

    fun returnReply(view: View) {
        mReply = findViewById(R.id.editText_second)
        val reply : String? = mReply.text.toString()

        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)

        setResult(RESULT_OK, replyIntent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart");
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause");
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart");
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume");
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}