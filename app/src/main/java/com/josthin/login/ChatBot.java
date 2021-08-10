package com.josthin.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatBot extends AppCompatActivity {
    MediaPlayer back;
    private RecyclerView chatsRV;
    private EditText userMsgEdt;
    private FloatingActionButton sendMsgFAB;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<ChatsModal> chatsModalArrayList;
    private ChatRVAdapter chatRVAdapter;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);
        FloatingActionButton btnBack = findViewById(R.id.backMenuChat);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(ChatBot.this,MenuApp.class);
            back.start();
            startActivity(intent);
            finish();
        });
        back = MediaPlayer.create(this,R.raw.back);
        chatsRV = findViewById(R.id.idRVchats);
        userMsgEdt = findViewById(R.id.idEdtMessage);
        sendMsgFAB = findViewById(R.id.idFABSend);
        chatsModalArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatsModalArrayList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        chatsRV.setLayoutManager(manager);
        chatsRV.setAdapter(chatRVAdapter);
        sendMsgFAB.setOnClickListener(v -> {
            if (userMsgEdt.getText().toString().isEmpty()){
                Toast.makeText(ChatBot.this, "Please enter your next", Toast.LENGTH_SHORT).show();
                return;
            }else {
                i += 1;
                switch (i){
                    case 1:
                        chatsModalArrayList.add(new ChatsModal(userMsgEdt.getText().toString(),USER_KEY));
                        userMsgEdt.setText("");
                        chatsModalArrayList.add(new ChatsModal("Hey!",BOT_KEY));
                        chatsModalArrayList.add(new ChatsModal("Hola!",BOT_KEY));
                        chatRVAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        chatsModalArrayList.add(new ChatsModal(userMsgEdt.getText().toString(),USER_KEY));
                        userMsgEdt.setText("");
                        chatsModalArrayList.add(new ChatsModal("Una pregunta común, te enseño...",BOT_KEY));
                        chatsModalArrayList.add(new ChatsModal("¿Viste lo que hizo el batedia? Que horror!",BOT_KEY));
                        chatRVAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        chatsModalArrayList.add(new ChatsModal(userMsgEdt.getText().toString(),USER_KEY));
                        userMsgEdt.setText("");
                            chatsModalArrayList.add(new ChatsModal("Tus compañeros deben estar pensando que es actuado",BOT_KEY));
                            chatsModalArrayList.add(new ChatsModal("jajajj",BOT_KEY));
                        chatRVAdapter.notifyDataSetChanged();
                        break;
                    case 4:
                        chatsModalArrayList.add(new ChatsModal(userMsgEdt.getText().toString(),USER_KEY));
                        userMsgEdt.setText("");
                            chatsModalArrayList.add(new ChatsModal("Curioso que intentes programar algo que tú ya eres",BOT_KEY));
                            chatsModalArrayList.add(new ChatsModal(":3",BOT_KEY));
                        chatRVAdapter.notifyDataSetChanged();
                        break;
                    case 5:
                        chatsModalArrayList.add(new ChatsModal(userMsgEdt.getText().toString(),USER_KEY));
                        userMsgEdt.setText("");
                            chatsModalArrayList.add(new ChatsModal("¿No te fijaste en la similitud de tu cerebro con la electrónica?",BOT_KEY));
                            chatsModalArrayList.add(new ChatsModal("Digo, jajajj",BOT_KEY));
                        chatsModalArrayList.add(new ChatsModal("Perdón me tengo que ir, háblame luego",BOT_KEY));
                        chatRVAdapter.notifyDataSetChanged();
                        break;
                    default:
                        Intent intent = new Intent(ChatBot.this, MenuApp.class);
                        back.start();
                        startActivity(intent);
                        break;
                }
            }
            //getResponse(userMsgEdt.getText().toString());
            //userMsgEdt.setText("");
        });
    }
    private void getResponse(String message){
        chatsModalArrayList.add(new ChatsModal(message,USER_KEY));
        chatRVAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=158513&key=Nsr6OeUZ0fmpxZcm&uid=[uid]&msg="+message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<MsgModal> call = retrofitAPI.getMessage(url);
        chatRVAdapter.notifyDataSetChanged();
        call.enqueue(new Callback<MsgModal>() {
            @Override
            public void onResponse(Call<MsgModal> call, Response<MsgModal> response) {
                if (response.isSuccessful()){
                    MsgModal modal = response.body();
                    chatsModalArrayList.add(new ChatsModal("Hey!",BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MsgModal> call, Throwable t) {
                chatsModalArrayList.add(new ChatsModal("Dime más claro tu mensaje por favor", BOT_KEY));
                chatRVAdapter.notifyDataSetChanged();
            }
        });
    }
}