package de.freshmaninandroid.app_programmierung.kitaguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KitasList extends AppCompatActivity {

    public static final String Kita_INTENT = "selectedKita";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitas_list);


        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,
                getAllKitasNames(getAllKitas()));
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                            @Override    // Go to KitasDetails activity
                                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                                Kita selectedKita = getAllKitas().get(position);
                                                Intent intent = new Intent(KitasList.this, KitasDetails.class);
                                                intent.putExtra(Kita_INTENT, selectedKita);
                                                startActivity(intent);
                                            }
                                        }
        );
    }

    public List<String> getAllKitasNames(List<Kita> allKitas) {

        List<String> kitasName = new ArrayList<>();

        for (Kita k : allKitas) {
            kitasName.add(k.getKitaname());
        }

        return kitasName;
    }


    public List<Kita> getAllKitas() {

        List<Kita> kitas = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.kitas);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String tempLine;


        try {
            while ((tempLine = reader.readLine()) != null) {

                if (tempLine.endsWith("^")) {
                    tempLine = tempLine + " ";
                }

                if (tempLine.startsWith("\uFEFF")) {
                    tempLine = tempLine.substring(1);
                }

                String[] elements = tempLine.split("\\^");

                kitas.add(new Kita(Integer.parseInt(elements[0]), elements[1], elements[2], elements[3],
                        elements[5], elements[6], elements[9], elements[10], elements[12], elements[13],
                        elements[14])); // Elements, which we want to show.

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return kitas;
    }
}
