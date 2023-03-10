package googleCodelabs.TwoActivities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PackageManagerCompat.LOG_TAG


private val TAG : String = MainActivity::class.java.simpleName.toString()

//public
val EXTRA_MESSAGE : String = "googleCodelabs.TwoActivities.extra.MESSAGE"

//public
val TEXT_REQUEST : Int = 1

class MainActivity : AppCompatActivity() {

    lateinit var mMessageEditText : EditText

    lateinit var mReplyHeadTextView : TextView
    lateinit var mReplyTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "-------");
        Log.d(TAG, "onCreate");

        mMessageEditText = findViewById(R.id.editText_main)

        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        if(savedInstanceState != null){
            val isVisible : Boolean = savedInstanceState.getBoolean("reply_visible")
            if(isVisible){
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getString("reply_text")
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (mReplyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text",mReplyTextView.text.toString());
        }
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
                mReplyTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
            }
        }
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