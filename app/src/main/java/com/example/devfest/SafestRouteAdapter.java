package com.example.devfest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SafestRouteAdapter extends RecyclerView.Adapter<SafestRouteAdapter.ViewHolder> {
    private List<Shelter> shelters;
    private OnItemClickListener onItemClickListener;

    public SafestRouteAdapter(List<Shelter> shelters) {
        this.shelters = shelters;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shelter_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shelter shelter = shelters.get(position);
        holder.bind(shelter);
    }

    @Override
    public int getItemCount() {
        return shelters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvShelterName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShelterName = itemView.findViewById(R.id.tvShelterName);
        }

        public void bind(Shelter shelter) {
            tvShelterName.setText(shelter.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(shelter);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Shelter shelter);
    }
}
