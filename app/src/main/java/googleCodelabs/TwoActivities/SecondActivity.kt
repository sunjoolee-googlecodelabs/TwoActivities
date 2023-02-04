package googleCodelabs.TwoActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

//public
val EXTRA_REPLY : String = "googleCodelabs.TwoActivities.extra.REPLY"

class SecondActivity : AppCompatActivity() {

    lateinit var mReply : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Get the Intent that activated this Activity
        val intent: Intent = intent
        val message : String? = intent.getStringExtra(EXTRA_MESSAGE)

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
}