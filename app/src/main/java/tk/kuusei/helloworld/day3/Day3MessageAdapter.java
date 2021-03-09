package tk.kuusei.helloworld.day3;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import tk.kuusei.helloworld.R;

public class Day3MessageAdapter extends BaseQuickAdapter<Day3Message, BaseViewHolder> {
    public Day3MessageAdapter() {
        super(R.layout.item_day3);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Day3Message newsBean) {
        baseViewHolder.setText(R.id.day3_id, String.valueOf(baseViewHolder.getAdapterPosition() + 1));
        baseViewHolder.setText(R.id.day3_message, newsBean.getMessage());
        baseViewHolder.setImageResource(R.id.day3_img, newsBean.getPicture());
    }
}

