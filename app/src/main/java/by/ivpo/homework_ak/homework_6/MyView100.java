package by.ivpo.homework_ak.homework_6;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

class MyView100 extends MyView {
    public MyView100(Context context) {
        super(context);
    }

    public MyView100(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        super.persent = 100;
    }

}
