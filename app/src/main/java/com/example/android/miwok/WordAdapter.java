package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> word, int backgroundColor)
    {
        super(context, 0, word);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word word = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.word_miwok);
        miwokTextView.setText(word.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.word_default);
        defaultTextView.setText(word.getDefaultTranslation());

        ImageView wordImageView = (ImageView) listItemView.findViewById(R.id.word_image);
        wordImageView.setImageResource(word.getImageResourceID());

        View textContainer = listItemView.findViewById(R.id.word_background);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
