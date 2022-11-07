package com.example.our_music;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView bnvOurMusic;
    private FrameLayout flContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bnvOurMusic.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.music_menu:
                        OpenFragment(new MusicFragment());
                        getSupportActionBar().setTitle("Music");
                        return true;
                }
                switch (item.getItemId())
                {
                    case R.id.album_menu:
                        OpenFragment(new AlbumFragment());
                        getSupportActionBar().setTitle("Album");
                        return true;
                }
                switch (item.getItemId())
                {
                    case R.id.artist_menu:
                        OpenFragment(new ArtistFragment());
                        getSupportActionBar().setTitle("Artist");
                        return true;
                }
                return false;
            }
        }
        );
    }
    private void initView()
    {
        bnvOurMusic = findViewById(R.id.bnv_our_music);
        flContainer = findViewById(R.id.fl_container);
    }
    private void OpenFragment(Fragment frm)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_container, frm);
        ft.commit();
    }
}