package com.example.xsandosgames;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class AddPlayers extends AppCompatActivity {
//    DrawerLayout drawerLayout;
//    ImageView menu;
//    LinearLayout home, play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

//        drawerLayout = findViewById(R.id.drawerLayout);
//        menu = findViewById(R.id.menu);
//        home = findViewById(R.id.home);
//        play = findViewById(R.id.play);
//
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDrawer(drawerLayout);
//            }
//        });
//
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                redirectActivity(AddPlayers.this, MainActivity.class);
//            }
//        });
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDrawer(drawerLayout);
//            }
//        });

        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame(playerOne.getText().toString(), playerTwo.getText().toString());
            }
        });
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    public void openGameActivity() {
        Log.d("AddPlayers", "Opening game activity");
        redirectActivity(AddPlayers.this, MainActivity2.class);
    }

    public void startGame(String playerOneName, String playerTwoName) {
        if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
            Toast.makeText(AddPlayers.this, "Please enter player names", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(AddPlayers.this, MainActivity2.class);
            intent.putExtra("playerOne", playerOneName);
            intent.putExtra("playerTwo", playerTwoName);
            startActivity(intent);
        }
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        closeDrawer(drawerLayout);
//    }
}
