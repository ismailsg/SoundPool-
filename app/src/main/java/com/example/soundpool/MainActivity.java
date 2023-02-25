package com.example.soundpool;



import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity
        extends AppCompatActivity {
    SoundPool soundPool;
    int game_over,
            level_complete,
            player_died;

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool
                    = new SoundPool(
                    3,
                    AudioManager.STREAM_MUSIC,
                    0);
//        }

        // This load function takes
        // three parameter context,
        // file_name and priority.
        game_over
                = soundPool
                .load(
                        this,
                        R.raw.game_over,
                        1);
        level_complete
                = soundPool.load(
                this,
                R.raw.level_complete,
                1);
        player_died
                = soundPool.load(
                this,
                R.raw.player_died,
                1);
    }

    public void playSound(View v)
    {
        int i;
        switch (v.getId()) {

            case R.id.button_sound1:
                soundPool.autoPause();

                i=soundPool.play(
                        game_over, 1, 1, 0, 0, 1);

                break;

            case R.id.button_sound2:
                soundPool.autoPause();
                soundPool.play(
                        player_died, 1, 1, 0, 0, 1);
//                soundPool.autoPause();
                break;

            case R.id.button_sound3:
                soundPool.autoPause();
                soundPool.play(
                        level_complete, 1, 1, 0, 0, 1);
//                soundPool.autoPause();
                break;
        }
    }
}
