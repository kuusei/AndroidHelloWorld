package tk.kuusei.helloworld.databinding;
import tk.kuusei.helloworld.R;
import tk.kuusei.helloworld.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding implements tk.kuusei.helloworld.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 4);
        sViewsWithIds.put(R.id.editTextTextPersonName, 5);
        sViewsWithIds.put(R.id.editTextTextPassword, 6);
        sViewsWithIds.put(R.id.login, 7);
        sViewsWithIds.put(R.id.nav, 8);
        sViewsWithIds.put(R.id.Room, 9);
        sViewsWithIds.put(R.id.guideline2, 10);
        sViewsWithIds.put(R.id.guideline3, 11);
        sViewsWithIds.put(R.id.guideline4, 12);
        sViewsWithIds.put(R.id.guideline5, 13);
        sViewsWithIds.put(R.id.guideline6, 14);
        sViewsWithIds.put(R.id.guideline7, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[1]
            , (android.widget.Button) bindings[2]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[5]
            , (androidx.constraintlayout.widget.Guideline) bindings[10]
            , (androidx.constraintlayout.widget.Guideline) bindings[11]
            , (androidx.constraintlayout.widget.Guideline) bindings[12]
            , (androidx.constraintlayout.widget.Guideline) bindings[13]
            , (androidx.constraintlayout.widget.Guideline) bindings[14]
            , (androidx.constraintlayout.widget.Guideline) bindings[15]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.Button) bindings[7]
            , (android.widget.Button) bindings[8]
            , (android.widget.TextView) bindings[3]
            );
        this.add1.setTag(null);
        this.add2.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new tk.kuusei.helloworld.generated.callback.OnClickListener(this, 2);
        mCallback1 = new tk.kuusei.helloworld.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.data == variableId) {
            setData((tk.kuusei.helloworld.GlobalViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setData(@Nullable tk.kuusei.helloworld.GlobalViewModel Data) {
        this.mData = Data;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeDataGetNumber((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeDataGetNumber(androidx.lifecycle.LiveData<java.lang.Integer> DataGetNumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int androidxDatabindingViewDataBindingSafeUnboxDataGetNumberGetValue = 0;
        androidx.lifecycle.LiveData<java.lang.Integer> dataGetNumber = null;
        tk.kuusei.helloworld.GlobalViewModel data = mData;
        java.lang.Integer dataGetNumberGetValue = null;
        java.lang.String stringValueOfDataGetNumber = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (data != null) {
                    // read data.getNumber()
                    dataGetNumber = data.getNumber();
                }
                updateLiveDataRegistration(0, dataGetNumber);


                if (dataGetNumber != null) {
                    // read data.getNumber().getValue()
                    dataGetNumberGetValue = dataGetNumber.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(data.getNumber().getValue())
                androidxDatabindingViewDataBindingSafeUnboxDataGetNumberGetValue = androidx.databinding.ViewDataBinding.safeUnbox(dataGetNumberGetValue);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(data.getNumber().getValue()))
                stringValueOfDataGetNumber = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxDataGetNumberGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.add1.setOnClickListener(mCallback1);
            this.add2.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, stringValueOfDataGetNumber);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // data != null
                boolean dataJavaLangObjectNull = false;
                // data
                tk.kuusei.helloworld.GlobalViewModel data = mData;



                dataJavaLangObjectNull = (data) != (null);
                if (dataJavaLangObjectNull) {



                    data.add(2);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // data != null
                boolean dataJavaLangObjectNull = false;
                // data
                tk.kuusei.helloworld.GlobalViewModel data = mData;



                dataJavaLangObjectNull = (data) != (null);
                if (dataJavaLangObjectNull) {


                    data.add();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): data.getNumber()
        flag 1 (0x2L): data
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}