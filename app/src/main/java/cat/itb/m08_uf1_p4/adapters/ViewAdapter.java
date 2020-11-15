package cat.itb.m08_uf1_p4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cat.itb.m08_uf1_p4.R;
import cat.itb.m08_uf1_p4.models.Character;

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
            holder.name = convertView.findViewById(R.id.textViewName);
            holder.waepon = convertView.findViewById(R.id.imageViewWeapon);
            holder.element = convertView.findViewById(R.id.imageViewElement);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Character character = (Character) getItem(position);
        holder.name.setText(character.getName());
        holder.waepon.setImageResource(character.getWaepon());
        holder.element.setImageResource(character.getElement());

        return convertView;
    }

    static class ViewHolder {
        private TextView name;
        private ImageView waepon, element;
    }
}
