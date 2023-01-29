package googleCodelabs.TwoActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var headerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        //자신을 발생시킨 인텐트 얻기
        val intent = intent
        val text_button_num : Int = intent.getIntExtra(EXTRA_TEXT_BUTTON_NUM, 0)

        textView = findViewById(R.id.third_activity_textView)
        headerTextView = findViewById(R.id.third_activity_header_textView)
        headerTextView.text = "You Pressed Text Button ${text_button_num}"

        textView.text = when(text_button_num){
            1-> getString(R.string.passage1)
            2-> getString(R.string.passage2)
            else-> getString(R.string.passage3)
        }
    }
}