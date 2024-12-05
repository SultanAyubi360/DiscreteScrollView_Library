package com.sultanayubi.discretescrollapp.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.sultanayubi.discretescrollviewlibrary.DiscreteScrollViewOptions;
import com.sultanayubi.discretescrollapp.MainActivity;
import com.sultanayubi.discretescrollapp.R;
import com.sultanayubi.discretescrollapp.databinding.ActivityShopBinding;
import com.sultanayubi.discretescrollviewlibrary.DSVOrientation;
import com.sultanayubi.discretescrollviewlibrary.DiscreteScrollView;
import com.sultanayubi.discretescrollviewlibrary.InfiniteScrollAdapter;
import com.sultanayubi.discretescrollviewlibrary.transform.ScaleTransformer;

import java.util.List;


public class ShopActivity extends AppCompatActivity implements DiscreteScrollView.OnItemChangedListener<ShopAdapter.ViewHolder>,
        View.OnClickListener {

    private List<Item> data;
    private Shop shop;

    private TextView currentItemName;
    private TextView currentItemPrice;
    private ImageView rateItemButton;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter<?> infiniteAdapter;

    private ActivityShopBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        currentItemName = binding.itemName;
        currentItemPrice = binding.itemPrice;
        rateItemButton = binding.itemBtnRateshop;

        shop = Shop.get();
        data = shop.getData();
        itemPicker = findViewById(R.id.item_picker);
        itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new ShopAdapter(data));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(data.get(0));

        binding.itemBtnRateshop.setOnClickListener(this);
        binding.homeshop.setOnClickListener(this);
    }

    private void onItemChanged(Item item) {
        currentItemName.setText(item.getName());
        currentItemPrice.setText(item.getPrice());
        changeRateButtonState(item);
    }

    private void changeRateButtonState(Item item) {
        if (shop.isRated(item.getId())) {
            rateItemButton.setImageResource(R.drawable.ic_star_black_24dp);
            rateItemButton.setColorFilter(ContextCompat.getColor(this, R.color.shopRatedStar));
        } else {
            rateItemButton.setImageResource(R.drawable.ic_star_border_black_24dp);
            rateItemButton.setColorFilter(ContextCompat.getColor(this, R.color.shopSecondary));
        }
    }

    @Override
    public void onCurrentItemChanged(@Nullable ShopAdapter.ViewHolder viewHolder, int adapterPosition) {
        int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
        onItemChanged(data.get(positionInDataSet));
    }

    private void showUnsupportedSnackBar() {
        Snackbar.make(itemPicker, R.string.msg_unsupported_op, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.item_btn_rateshop) {
            int realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
            Item current = data.get(realPosition);
            shop.setRated(current.getId(), !shop.isRated(current.getId()));
            changeRateButtonState(current);
        } else if (v.getId() == R.id.homeshop) {
            start(MainActivity.class);
            finish();
        } else {
            showUnsupportedSnackBar(); // Handle unsupported actions
        }

    }

    private void start(Class<? extends Activity> token) {
        Intent intent = new Intent(this, token);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
