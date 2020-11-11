package cat.itb.m08_uf1_p4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cat.itb.m08_uf1_p4.R;

public class ViewAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Character> characters;

    public ViewAdapter(Context context, int layout, List<Character> characters) {
        this.context = context;
        this.layout = layout;
        this.characters = characters;
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Object getItem(int position) {
        return characters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);

            holder = new ViewHolder();
            //TODO
            holder.textView = convertView.findViewById(R.id.listView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Character character = (Character) getItem(position);
        holder.textView.

        return null;
    }

    static class ViewHolder {
        private TextView textView;
    }
}
