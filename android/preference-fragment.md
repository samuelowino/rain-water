# PreferenceFragment

This is a **Fragment** that serves as the main entry point for the **preference library**. PreferenceFragment displays a hierarchy of preference screens to the user, it also persists the chosen values to the device.

Use **getDefaultSharedPreference** to obtain an instance of **SharedPreferences** that the library uses.

Use **setPreferenceFromResource** to inflate the preference.xml file.

```kotlin
class AppPreferenceFragment: SharedPreferenceFragment(){
    override fun onCreatePreference(savedInstanceState: Bundle, rootKey: String){
        setPreferenceFromResource(R.xml.preferences, rootKey)
    }
}
```

