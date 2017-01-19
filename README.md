# MVVM-Pattern & DataBinding

It is base on mvvm pattern Android sample and use Data Binding library to display data and bind UI elements to actions.

The Model-View-ViewModel, its intent is to provide a clean separation of concerns between the user interface controls and their logic.

![mvvm pattern](https://github.com/qindachang/MVVM-Pattern/tree/master/pic/IC564167.png)

The components are decoupled from each other, thus enabling:

 * Components to be swapped
 * Internal implementation to be changed without affecting the others
 * Components to be worked on independently
 * Isolated unit testing

###View

```java
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        mViewDataBinding = FragmentStatisticsBinding.bind(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mICommand = new StatisticsViewModel(getContext(), this);
        mViewDataBinding.setCommand(mICommand);
    }
```

```xml
<TextView
    android:text="@={command.model.text}"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>

<Button
    android:textColor="#ffffff"
    android:onClick="@{()->command.onButtonAddClick()}"
    android:text="+1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>
```
###Model

```java
public class StatisticsModel extends BaseObservable {
    private String text;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
}
```

###ViewModel

```java
public class StatisticsViewModel implements StatisticsContract.ICommand {
    private int number;
    private boolean control;

    private Context mContext;
    private StatisticsContract.INotifyPropertyChanged mINotifyPropertyChanged;
    private StatisticsModel mModel;

    public StatisticsViewModel(Context context, StatisticsContract.INotifyPropertyChanged INotifyPropertyChanged) {
        mContext = context;
        mINotifyPropertyChanged = INotifyPropertyChanged;
        mModel = new StatisticsModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        mContext = null;
    }

    @Override
    public StatisticsModel getModel() {
        return mModel;
    }

    @Override
    public void onButtonAddClick() {
        number += 1;
        mModel.setText(String.valueOf(number));
    }

    @Override
    public void onButtonControlClick() {
        control = !control;
        mINotifyPropertyChanged.onIdViewControlChange(control);
    }
}
```

##Study

googlesamples/android-architecture [TODO-DataBinding](https://github.com/googlesamples/android-architecture/tree/dev-todo-mvvm-databinding/ "TODO-DataBinding")

Microsoft [The MVVM Pattern](https://msdn.microsoft.com/en-us/library/hh848246.aspx "The MVVM Pattern")

##Using open source code

Google [ActivityUtils](https://github.com/googlesamples/android-architecture/blob/dev-todo-mvvm-databinding/todoapp/app/src/main/java/com/example/android/architecture/blueprints/todoapp/util/ActivityUtils.java "ActivityUtils")

