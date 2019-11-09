package com.example.form
//不用按確認送出按鈕,選擇對話會短暫出現
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var spinner4: Spinner
    //lateinit var msg:TextView
   // lateinit var submit:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        spinner4=findViewById(R.id.spinner4)
        
        var adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,//容器（main)
            R.array.fruits,//要新增的資料（剛增在res/xml)
            R.layout.support_simple_spinner_dropdown_item
        ).      //View
        spinner.adapter = adapter
        var adapter4: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.time,
            R.layout.support_simple_spinner_dropdown_item
        )

        spinner.adapter = adapter
        spinner4.adapter = adapter4
//清單spinner下拉選項
        spinner.onItemSelectedListener = object  :AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var item: Any = parent!!.getItemAtPosition(position)
//差別:短暫顯示
                textView.setText(item.toString())
                Toast.makeText(this@MainActivity, "您所選擇的水果是:$item", Toast.LENGTH_LONG).show()
            }
        }


        spinner4.onItemSelectedListener = object  :AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var item: Any = parent!!.getItemAtPosition(position)
                textView.setText(item.toString())
                Toast.makeText(this@MainActivity, "您所選擇的時間是:$item", Toast.LENGTH_LONG).show()
            }
        }
//圓-二選一-點選紐
            var lay:RadioGroup= findViewById(R.id.lay)
//核取方塊
            var drink1:CheckBox= findViewById(R.id.checkBox2)
            var drink2:CheckBox= findViewById(R.id.checkBox3)
            var drink3:CheckBox= findViewById(R.id.checkBox4)

        lay.setOnCheckedChangeListener { group, checkedId ->
            var radio:RadioButton= findViewById(checkedId)
            Toast.makeText(this@MainActivity, "你選了:"+radio.text.toString(),Toast.LENGTH_LONG).show()
        }
          //實驗,沒也沒關係
        //drink1 .isChecked=false
        drink1.setOnCheckedChangeListener{buttonView, isChecked ->
            Toast.makeText(this@MainActivity,   "你${if (isChecked)"選了:" else "取消選取"}可樂",Toast.LENGTH_LONG).show()
        }
        //drink2 .isChecked=false
        drink2.setOnCheckedChangeListener{buttonView, isChecked ->
            Toast.makeText(this@MainActivity, "已${if (isChecked) "選了:" else "取消選取"}果汁", Toast.LENGTH_LONG).show()
        }
        //drink3 .isChecked=false
        drink3.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked)Toast.makeText(this@MainActivity, "已選取咖啡", Toast.LENGTH_LONG).show()
        }

}
}
