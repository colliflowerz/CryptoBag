package au.edu.unsw.infs3634.cryptobag;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.content.Intent.getIntent;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {
    private Coin mCoin;
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;


    public DetailFragment() {
        // Required empty public constructor
    }


    public void onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_detail,container,false);
        mName = view.findViewById(R.id.tvName);
        mSymbol = view.findViewById(R.id.tvSymbol);
        mValue = view.findViewById(R.id.tvValueField);
        mChange1h = view.findViewById(R.id.tvChange1hField);
        mChange24h = view.findViewById(R.id.tvChange24hField);
        mChange7d = view.findViewById(R.id.tvChange7dField);
        mMarketcap = view.findViewById(R.id.tvMarketcapField);
        mVolume = view.findViewById(R.id.tvVolumeField);
        mSearch = view.findViewById(R.id.ivSearch);

        int position1 = getArguments().getInt(MainActivity.EXTRA_MESSAGE, 0);

        Intent intent = getActivity().getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        mCoin = Coin.getCoins().get(position);
        mCoin = Coin.getCoins().get(position1);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        mName.setText(mCoin.getName());
        mSymbol.setText(mCoin.getSymbol());
        mValue.setText(formatter.format(mCoin.getValue()));
        mChange1h.setText(String.valueOf(mCoin.getChange1h()) + " %");
        mChange24h.setText(String.valueOf(mCoin.getChange24h()) + " %");
        mChange7d.setText(String.valueOf(mCoin.getChange7d()) + " %");
        mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
        mVolume.setText(formatter.format(mCoin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCoin(mCoin.getName());
            }
        });
    }

    private void searchCoin(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        mName = view.findViewById(R.id.tvName);
        mSymbol = view.findViewById(R.id.tvSymbol);
        mValue = view.findViewById(R.id.tvValueField);
        mChange1h = view.findViewById(R.id.tvChange1hField);
        mChange24h = view.findViewById(R.id.tvChange24hField);
        mChange7d = view.findViewById(R.id.tvChange7dField);
        mMarketcap = view.findViewById(R.id.tvMarketcapField);
        mVolume = view.findViewById(R.id.tvVolumeField);
        mSearch = view.findViewById(R.id.ivSearch);

        int position1 = getArguments().getInt(MainActivity.EXTRA_MESSAGE, 0);

        Intent intent = getActivity().getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        mCoin = Coin.getCoins().get(position);
        mCoin = Coin.getCoins().get(position1);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        mName.setText(mCoin.getName());
        mSymbol.setText(mCoin.getSymbol());
        mValue.setText(formatter.format(mCoin.getValue()));
        mChange1h.setText(String.valueOf(mCoin.getChange1h()) + " %");
        mChange24h.setText(String.valueOf(mCoin.getChange24h()) + " %");
        mChange7d.setText(String.valueOf(mCoin.getChange7d()) + " %");
        mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
        mVolume.setText(formatter.format(mCoin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCoin(mCoin.getName());
            }
        });
        return view;

    }

    @Override
    public void onClick(View v) {

    }
}
