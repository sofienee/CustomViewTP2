package com.example.customviewtp2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity
{
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        int[] imageArray = {R.drawable.word, R.drawable.excel, R.drawable.powerpoint, R.drawable.outlook};

        String[] nameList = {"Word","Excel","PowerPoint","Outlook"};

        String[] descriptionList = {"Editeur de texte", "Tableur", "Logiciel de présentation", "Client de courrier électronique" };

        listt list = new listt(this, imageArray, nameList, descriptionList);
        listView.setAdapter(list);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(i == 0)
                {
                    Toast.makeText(MainActivity.this, "Word", Toast.LENGTH_SHORT).show();
                }
                else if (i == 1)
                {
                    Toast.makeText(MainActivity.this, "Excel", Toast.LENGTH_SHORT).show();
                }
                else if (i == 2)
                {
                    Toast.makeText(MainActivity.this, "PowerPoint", Toast.LENGTH_SHORT).show();
                }
                else if (i == 3)
                {
                    Toast.makeText(MainActivity.this, "Outlook", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Try Again !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Sélection item");

                if(position == 0)
                {
                    builder.setMessage("Votre choix : Word");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 1)
                {
                    builder.setMessage("Votre choix : Excel");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 2)
                {
                    builder.setMessage("Votre choix : PowerPoint");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 3)
                {
                    builder.setMessage("Votre choix : Outlook");
                    Log.e("tag" , "position " + position);
                }
                else
                {
                    builder.setMessage("Try Again !!");
                    Log.e("tag" , "position " + position);
                }

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {

                    }
                });

                AlertDialog alert11 = builder.create();
                alert11.show();

                return true;
            }
        });
    }
}