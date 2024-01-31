package skkk.dfs.my3app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public int count = 999999;
    ProgressBar progressBar;
    int score_gold = 0;
    ImageView sculpture;
    private SharedPreferences count_pref;
    private SharedPreferences gold_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count_pref = getSharedPreferences("count_pref",MODE_PRIVATE);
        count = count_pref.getInt("save_key_count", count);

        gold_pref = getSharedPreferences("gold_pref",MODE_PRIVATE);
        score_gold = gold_pref.getInt("save_key_gold", score_gold);

        TextView text_count = findViewById(R.id.text_count);
        text_count.setText(count+"");

        TextView goldtxt = findViewById(R.id.goldtxt);
        goldtxt.setText(getString(R.string.txt_gold)+" "+ score_gold);

        progressBar = findViewById(R.id.progress);
        progressBar.setProgress(count);
        FloatingActionButton gotoshop = findViewById(R.id.gotoshop);
        gotoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = count_pref.edit();
                editor.putInt("save_key_count", count);
                editor.commit();

                SharedPreferences.Editor editor2 = gold_pref.edit();
                editor2.putInt("save_key_gold", score_gold);
                editor2.commit();
            }
        });

        sculpture = findViewById(R.id.sculpture);
        imgSet();
        sculpture.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    //если коснулсяя картинки сработает этот код

                    count = count-10000;
                    text_count.setText(count+"");
                    score_gold = score_gold+1;
                    goldtxt.setText(getString(R.string.txt_gold)+" "+ score_gold);
                    progressBar.setProgress(count);

                    v.animate().scaleX(0.99f).scaleY(0.99f).setDuration(0);
                    imgSet();
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    //Если отпустил палец сработает этот код
                    v.animate().scaleX(1f).scaleY(1f).setDuration(0);
                }
                return true;
            }
        });

        CardView tools = findViewById(R.id.tools);
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = count_pref.edit();
                editor.putInt("save_key_count", count);
                editor.commit();

                SharedPreferences.Editor editor2 = gold_pref.edit();
                editor2.putInt("save_key_gold", score_gold);
                editor2.commit();
            }
        });

    }
    //метод с условием смены картинок - начало

    public void imgSet(){
        if(count>999499){sculpture.setImageResource(R.drawable.img_20);}
        if(count<=999499 & count>998099){sculpture.setImageResource(R.drawable.img_19);}
        if(count<=998099 & count>995499){sculpture.setImageResource(R.drawable.img_18);}
        if(count<=995499 & count>990899){sculpture.setImageResource(R.drawable.img_17);}
        if(count<=990899 & count>983499){sculpture.setImageResource(R.drawable.img_16);}
        if(count<=983499 & count>972499){sculpture.setImageResource(R.drawable.img_15);}
        if(count<=972499 & count>957099){sculpture.setImageResource(R.drawable.img_14);}
        if(count<=957099 & count>936499){sculpture.setImageResource(R.drawable.img_13);}
        if(count<=936499 & count>909899){sculpture.setImageResource(R.drawable.img_12);}
        if(count<=909899 & count>876499){sculpture.setImageResource(R.drawable.img_11);}
        if(count<=876499 & count>835499){sculpture.setImageResource(R.drawable.img_10);}
        if(count<=835499 & count>786099){sculpture.setImageResource(R.drawable.img_9);}
        if(count<=786099 & count>727499){sculpture.setImageResource(R.drawable.img_8);}
        if(count<=727499 & count>658899){sculpture.setImageResource(R.drawable.img_7);}
        if(count<=658899 & count>579499){sculpture.setImageResource(R.drawable.img_6);}
        if(count<=579499 & count>488499){sculpture.setImageResource(R.drawable.img_5);}
        if(count<=488499 & count>385099){sculpture.setImageResource(R.drawable.img_4);}
        if(count<=385099 & count>268499){sculpture.setImageResource(R.drawable.img_3);}
        if(count<=268499 & count>137899){sculpture.setImageResource(R.drawable.img_2);}
        if(count<=137899 & count>0){sculpture.setImageResource(R.drawable.img_1);}
        if(count<=0){sculpture.setImageResource(R.drawable.img_0);}

    }

    //метод с условием смены картинок - конец

    //Системная кнопка назад- начало

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = count_pref.edit();
        editor.putInt("save_key_count", count);
        editor.commit();

        SharedPreferences.Editor editor2 = gold_pref.edit();
        editor2.putInt("save_key_gold", score_gold);
        editor2.commit();

        super.onBackPressed();
    }

    //Системная кнопка назад- конец

}