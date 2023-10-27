package pl.zs10.chessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CountDownTimer czasomierz;
    int sek = 180;
    TextView textView;
    int min = 0;
    Button startB,stopB,resetB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        startB = findViewById(R.id.button);
        stopB = findViewById(R.id.button2);
        resetB = findViewById(R.id.button3);


        startB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czasomierz = new CountDownTimer(sek * 1000, 1000) {
                            @Override
                            public void onTick(long l) {
                                sek = (int) l / 1000;
                                min = (int) sek / 60;
                                textView.setText(String.valueOf(min));
                            }

                            @Override
                            public void onFinish() {
                                textView.setText("GAME OVER");
                            }
                        };
                        czasomierz.start();
                    }

                }
        );

        stopB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(czasomierz!=null){
                            czasomierz.cancel();
                        }
                    }
                }
        );

        resetB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czasomierz.start();
                    }
                }
        );

    }
}