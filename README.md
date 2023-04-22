# progressBar

This is part of our PLANer

# Problem

1. how to call multiple progress bar


# Steps

1. App -> res --> layout --> activity_main.xml --> change line 2 [change "androidx" into LinearLayout], and add two lines of code

For example:

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"


android:gravity="center"
android:padding="16dp"
```


2. Create progress bar & button UI [App -> res --> layout --> activity_main.xml] 

```
  <ProgressBar
        android:id="@+id/progressBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        style="?android:attr/progressBarStyleHorizontal"
        
        // look at #3
        android:progressDrawable="@drawable/progressbar_bg"/>
```


// Not need to create this button, we can use what we have. [for documentation purposes]
```
 <Button
        android:id="@+id/start"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Start"/>
```


3. App -> res --> drawable

  right click --> new --> Kotlin File/Class
  
  File name: progressbar_bg.xml. --> click on OK
  
  ```
  <?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">


  // background for our progress bar
    <item android:id="@android:id/background">
        <shape android:shape="rectangle">
            <corners android:radius="6dp"/>
            <solid android:color="#D2EDFC"/>
        </shape>
    </item>

  // progress
    <item android:id="@android:id/progress">
        <scale android:scaleWidth="100%">
            <shape android:shape="rectangle">
                <corners android:radius="6dp"/>
                <solid android:color="#287CF6"/>
            </shape>
        </scale>
    </item>

</layer-list>
  
  ```


4. In java file

```
    private int goalsCounter = 100;

    private int goalsCompletedCounter = 10;

    public ProgressBar progressBar;
    
    
    
    
    
    // Call this function when a new plan has been added or update a exist plan
    public void displayProgressBar(int goalsCounter,int goalsCompletedCounter){

        progressBar = findViewById(R.id.progressBar);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setContentView(R.layout.activity_main);
                progressBar.setIndeterminate(false);
                if(goalsCounter == 0 || goalsCounter/goalsCompletedCounter <= 0 ){
                    progressBar.setVisibility(View.INVISIBLE);
                }else{
                    progressBar.setMax(goalsCounter);
                    progressBar.setProgress(goalsCompletedCounter);
                }


            }
        });
    }
```




# Screenshot 

![alt tag](https://github.com/LinxinJiang/progressBar/blob/main/example.png)
