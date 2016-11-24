package de.freshmaninandroid.app_programmierung.kitaguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class KitasDetails extends AppCompatActivity {
    private Kita selectedKita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitas_details);
        setTitle("Kita Details");

        Intent intent = getIntent();
        selectedKita = (Kita) intent.getSerializableExtra(KitasList
                .Kita_INTENT);

        TextView kitasName = (TextView) findViewById(R.id.name_view);
        TextView kitasStreet = (TextView) findViewById(R.id.street_view);
        TextView kitasPlace = (TextView) findViewById(R.id.place_view);
        TextView kitasContact = (TextView) findViewById(R.id.contact_view);
        TextView kitasTel = (TextView) findViewById(R.id.tel_view);
        TextView kitasProvider = (TextView) findViewById(R.id.provider_view);

        kitasName.setText(selectedKita.getKitaname());
        kitasStreet.setText(selectedKita.getStreet() + " " + selectedKita.getHouseNo());
        kitasPlace.setText(selectedKita.getPostal() + " " + selectedKita.getPlace());
        kitasContact.setText(selectedKita.getContactName());
        kitasProvider.setText(selectedKita.getProvider());
        kitasTel.setText(selectedKita.getTelNo());
    }

    public void selectKita(View view) {

        if (selectedKita.getUrl().isEmpty()) {
            Toast.makeText(this, "No Link", Toast.LENGTH_LONG).show();
            return;
        }

        String url = "http://" + selectedKita.getUrl();

        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);

    }
}