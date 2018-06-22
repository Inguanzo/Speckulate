package com.speckulate.speckulate.Feed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.speckulate.speckulate.PhotosFragment;
import com.speckulate.speckulate.R;

import java.util.ArrayList;
import java.util.List;


public class FeedActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.horizontal_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.card_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        final ContactAdapter contactAdapter = new ContactAdapter(createList(3));
        recyclerView.setAdapter(contactAdapter);

        final LinearLayout cardView = (LinearLayout) findViewById(R.id.card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactAdapter.addItem();
                contactAdapter.notifyDataSetChanged();
                cardView.setVisibility(View.GONE);
            }
        });
    }


    private List<ContactInfo> createList(int size) {

        List<ContactInfo> result = new ArrayList<ContactInfo>();
        for (int i=1; i <= size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = ContactInfo.NAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";

            result.add(ci);

        }

        return result;
    }
}
