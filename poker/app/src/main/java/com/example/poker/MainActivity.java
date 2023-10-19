package com.example.poker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButtonYourCard1;
    ImageButton imageButtonYourCard2;
    ImageButton imageButtonYourCard3;

    ImageButton imageButtonMyCard1;
    ImageButton imageButtonMyCard2;
    ImageButton imageButtonMyCard3;

    ImageButton imageButtonResult;

    TextView textViewResult;
    Button buttonPlay;

    int myCardOpening = 0;
    int yourCardOpening = 0;

    int[] allCards = new int[] {
      R.drawable.la1chuon, R.drawable.la2chuon,
      R.drawable.la3chuon, R.drawable.la4chuon,
      R.drawable.la5chuon, R.drawable.la6chuon,
      R.drawable.la7chuon, R.drawable.la8chuon,
      R.drawable.la9chuon, R.drawable.la10chuon,
      R.drawable.lajchuon, R.drawable.laqchuon,
      R.drawable.lakchuon,
      R.drawable.la1bich, R.drawable.la2bich,
      R.drawable.la3bich, R.drawable.la4bich,
      R.drawable.la5bich, R.drawable.la6bich,
      R.drawable.la7bich, R.drawable.la8bich,
      R.drawable.la9bich, R.drawable.la10bich,
      R.drawable.lajbich, R.drawable.laqbich,
      R.drawable.lakbich,
      R.drawable.la1ro, R.drawable.la2ro,
      R.drawable.la3ro, R.drawable.la4ro,
      R.drawable.la5ro, R.drawable.la6ro,
      R.drawable.la7ro, R.drawable.la8ro,
      R.drawable.la9ro, R.drawable.la10ro,
      R.drawable.lajro, R.drawable.laqro,
      R.drawable.lakro,
      R.drawable.la1co, R.drawable.la2co,
      R.drawable.la3co, R.drawable.la4co,
      R.drawable.la5co, R.drawable.la6co,
      R.drawable.la7co, R.drawable.la8co,
      R.drawable.la9co, R.drawable.la10co,
      R.drawable.lajco, R.drawable.laqco,
      R.drawable.lakco
    };
    int[] allCardsPoint = new int[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
    };
    int[] selectedCards = new int[6];
    int myPoint = 0;
    int yourPoint = 0;
    Random ramdom = new Random(System.currentTimeMillis());
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAllWidgets();
        ResetAll();
        setAllEvents();
    };
    @SuppressLint("ResourceType")
    private void ResetAll() {
        imageButtonYourCard1.setImageResource(R.drawable.labia);
        imageButtonYourCard2.setImageResource(R.drawable.labia);
        imageButtonYourCard3.setImageResource(R.drawable.labia);

        imageButtonMyCard1.setImageResource(R.drawable.labia);
        imageButtonMyCard2.setImageResource(R.drawable.labia);
        imageButtonMyCard3.setImageResource(R.drawable.labia);

        imageButtonResult.setImageResource(R.drawable.labia);

        myCardOpening = 0;
        yourCardOpening = 0;
        myPoint = 0;
        yourPoint = 0;

        selectedCards = new int[] {-1, -1, -1, -1, -1, -1};
    }

    private void findAllWidgets() {
        imageButtonYourCard1 = findViewById(R.id.imageButtonYourCard1);
        imageButtonYourCard2 = findViewById(R.id.imageButtonYourCard2);
        imageButtonYourCard3 = findViewById(R.id.imageButtonYourCard3);

        imageButtonMyCard1 = findViewById(R.id.imageButtonMyCard1);
        imageButtonMyCard2 = findViewById(R.id.imageButtonMyCard2);
        imageButtonMyCard3 = findViewById(R.id.imageButtonMyCard3);

        imageButtonResult = findViewById(R.id.imageButtonResult);

        textViewResult = findViewById(R.id.textViewResult);
        buttonPlay = findViewById(R.id.buttonPlay);
    }
    private void setAllEvents() {
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResult.setText("Hãy đợi đấy!");
                ResetAll();
            }
        });
        imageButtonYourCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickYourCard(view);
            }
        });
        imageButtonYourCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickYourCard(view);
            }
        });
        imageButtonYourCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickYourCard(view);
            }
        });
        imageButtonMyCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMyCard(view);
            }
        });
        imageButtonMyCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMyCard(view);
            }
        });
        imageButtonMyCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMyCard(view);
            }
        });
    }
    private boolean cardIsSelected(int index) {

        for (int i = 0; i < selectedCards.length; i++) {
            if (selectedCards[i] == index)
                return true;
        }
        return false;


    };
    private  int getRamdomIndex() {

        int cardsCout = allCards.length -1;
        int ramdomIndex;
        do {
            ramdomIndex = ramdom.nextInt(cardsCout);
        }while (cardIsSelected(ramdomIndex));
        return ramdomIndex;
    };
    private void showMessage(String message) {
        textViewResult.setText(message);
    }
    private void showResult() {
        if (myPoint == 30) {
            textViewResult.setText("haha, win!  Bù, game quá dễ");
            imageButtonResult.setImageResource(R.drawable.win);
            return;
        } else if (yourPoint == 30) {
            textViewResult.setText("ghê Ba tây luôn, tại hạ xin thua");
            imageButtonResult.setImageResource(R.drawable.lost);
            return;
        }
        myPoint = myPoint%10;
        yourPoint = yourPoint%10;
        
        if (myPoint > yourPoint) {
            textViewResult.setText("haha, win!  Mình " + myPoint + " nút");
            imageButtonResult.setImageResource(R.drawable.win);
        }
        else {
            textViewResult.setText("May mắn à!  Nhường đấy. Bạn có " + yourPoint +" nút");
            imageButtonResult.setImageResource(R.drawable.lost);
        }
    }
    public void onClickMyCard(View view) {
        if (myCardOpening == 3 && yourCardOpening == 3) {
            showMessage("xin mời chơi ván mới");
            return;
        }
        int ramdomIndex = getRamdomIndex();
        int ramdomCardIndex = allCards[ramdomIndex];
        int point = allCardsPoint[ramdomIndex];
        
        if (myCardOpening == 0) {
            imageButtonMyCard3.setImageResource(ramdomCardIndex);
            myCardOpening = 1;
            myPoint += point;
            selectedCards[0] = ramdomCardIndex;
        } else if (myCardOpening == 1) {
            imageButtonMyCard2.setImageResource(ramdomCardIndex);
            myCardOpening = 2;
            myPoint += point;
            selectedCards[1] = ramdomCardIndex;
        } else if (myCardOpening == 2) {
            imageButtonMyCard1.setImageResource(ramdomCardIndex);
            myCardOpening = 3;
            myPoint += point;
            selectedCards[2] = ramdomCardIndex;
        }
        if (myCardOpening == 3 && yourCardOpening == 3) {
            showResult();
        } else if (myCardOpening == 3 && yourCardOpening != 3) {
            showMessage("xin mời lật bài tiếp của bạn");
        }
    }
    public void onClickYourCard(View view) {
        if (myCardOpening == 3 && yourCardOpening == 3) {
            showMessage("xin mời chơi ván mới");
            return;
        }
        int ramdomIndex = getRamdomIndex();
        int ramdomCardIndex = allCards[ramdomIndex];
        int point = allCardsPoint[ramdomIndex];

        if (yourCardOpening == 0) {
            imageButtonYourCard3.setImageResource(ramdomCardIndex);
            yourCardOpening = 1;
            yourPoint += point;
            selectedCards[3] = ramdomCardIndex;
        } else if (yourCardOpening == 1) {
            imageButtonYourCard2.setImageResource(ramdomCardIndex);
            yourCardOpening = 2;
            yourPoint += point;
            selectedCards[4] = ramdomCardIndex;
        } else if (yourCardOpening == 2) {
            imageButtonYourCard1.setImageResource(ramdomCardIndex);
            yourCardOpening = 3;
            yourPoint += point;
            selectedCards[5] = ramdomCardIndex;
        }
        if (yourCardOpening == 3 && myCardOpening == 3) {
            showResult();
        } else if (yourCardOpening == 3 && myCardOpening != 3) {
            showMessage("miếng nữa đi");
        }
    }
}