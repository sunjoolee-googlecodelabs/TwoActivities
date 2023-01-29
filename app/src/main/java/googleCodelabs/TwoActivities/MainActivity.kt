package googleCodelabs.TwoActivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


private val TAG : String = MainActivity::class.java.simpleName.toString()

//public
val EXTRA_MESSAGE : String = "googleCodelabs.TwoActivities.extra.MESSAGE"

//public
val EXTRA_TEXT_BUTTON_NUM : String = "googleCodelabs.TwoActivities.extra.TEXT_BUTTON_NUM"

//public
val TEXT_REQUEST : Int = 1

class MainActivity : AppCompatActivity() {

    lateinit var mMessageEditText : EditText

    lateinit var mReplyHeadTextView : TextView
    lateinit var mReplyTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main)

        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }

    fun launchSecondActivity(view: View) {
        Log.d(TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)

        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)

        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                val reply = data?.getStringExtra(EXTRA_REPLY)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

    fun textButtonClicked(view: View) {
        val text_button_num : Int = when(view.id){
            R.id.text_button1 -> 1
            R.id.text_button2 -> 2
            else -> 3
        }
        Log.d(TAG, "Text Button ${text_button_num} clicked!")

        intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra(EXTRA_TEXT_BUTTON_NUM, text_button_num)

        startActivity(intent)
    }
}