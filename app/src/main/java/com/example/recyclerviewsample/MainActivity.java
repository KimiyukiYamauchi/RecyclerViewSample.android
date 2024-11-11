package com.example.recyclerviewsample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Toolbarを取得
        Toolbar toolbar = findViewById(R.id.toolbar);
        // ツールバーにロゴを設定
        toolbar.setLogo(R.mipmap.ic_launcher);
        // アクションバーにツールバーを設定
        setSupportActionBar(toolbar);
        // CollapsingToolbarLayoutを取得
        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbarLayout);
        // タイトルを設定
        toolbarLayout.setTitle(getString(R.string.toolbar_title));
        // 通常サイズ時の文字色を設定
        toolbarLayout.setExpandedTitleColor(Color.WHITE);
        // 縮小サイズ時の文字色を設定
        toolbarLayout.setCollapsedTitleTextColor(Color.GRAY);

        RecyclerView rvMenu = findViewById(R.id.rvMenu);
        LinearLayoutManager layout = new LinearLayoutManager(MainActivity.this);
        rvMenu.setLayoutManager(layout);
        List<Map<String, Object>> menuList = createTeishokuList();
        RecyclerListAdapter adapter = new RecyclerListAdapter(menuList);
        rvMenu.setAdapter(adapter);
        DividerItemDecoration decorator = new DividerItemDecoration(MainActivity.this, layout.getOrientation());
        rvMenu.addItemDecoration(decorator);
    }

    private List<Map<String, Object>> createTeishokuList() {
        List<Map<String, Object>> menuList = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc", "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 850);
        menu.put("desc", "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 950);
        menu.put("desc", "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;

    }

    private class RecyclerListViewHolder extends RecyclerView.ViewHolder {
        public TextView _tvMenuNameRow;
        public TextView _tvMenuPriceRow;

        public RecyclerListViewHolder(@NonNull View itemView) {
            super(itemView);
            _tvMenuNameRow = itemView.findViewById(R.id.tvMenuNameRow);
            _tvMenuPriceRow = itemView.findViewById(R.id.tvMenuPriceRow);
        }
    }

    private class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListViewHolder> {
        private List<Map<String, Object>> _listData;

        public RecyclerListAdapter(List<Map<String, Object>> _listData) {
            this._listData = _listData;
        }

        @NonNull
        @Override
        public RecyclerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.row, parent, false);
            view.setOnClickListener(new ItemClickListener());
            RecyclerListViewHolder holder = new RecyclerListViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerListViewHolder holder, int position) {
            Map<String, Object> item = _listData.get(position);
            String menuName  = (String) item.get("name");
            int menuPrice = (Integer) item.get("price");
            String menuPriceStr = String.valueOf(menuPrice);
            holder._tvMenuNameRow.setText(menuName);
            holder._tvMenuPriceRow.setText(menuPriceStr);
        }

        @Override
        public int getItemCount() {
            return _listData.size();
        }
    }

    private class ItemClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            TextView tvMenuName = view.findViewById(R.id.tvMenuNameRow);
            String menuName = tvMenuName.getText().toString();
            String msg = getString(R.string.msg_header) + menuName;
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}