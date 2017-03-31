package com.example.samsung.p0681_parcel;

import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    Parcel parcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeParcel();
        readeParcel();
    }

    private void writeParcel() {

        parcel = Parcel.obtain();

        byte b = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        String s = "abcdefgh";

        logWriteInfo("before writing");
        parcel.writeByte(b);
        logWriteInfo("byte");
        parcel.writeInt(i);
        logWriteInfo("int");
        parcel.writeLong(l);
        logWriteInfo("long");
        parcel.writeFloat(f);
        logWriteInfo("float");
        parcel.writeDouble(d);
        logWriteInfo("double");
        parcel.writeString(s);
        logWriteInfo("String");
    }

    private void logWriteInfo(String s) {
        String message = s + ": " + "dataSize = " + parcel.dataSize();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d(LOG_TAG, message);
    }

    private void readeParcel() {

        logReadInfo("before reading");

        parcel.setDataPosition(0);
        logReadInfo("byte = " + parcel.readByte());
        logReadInfo("int = " + parcel.readInt());
        logReadInfo("long = " + parcel.readLong());
        logReadInfo("float = " + parcel.readFloat());
        logReadInfo("double = " + parcel.readDouble());
        logReadInfo("String = " + parcel.readString());
    }

    private void logReadInfo(String s) {
        String message = s + ": " + "dataPosition = " + parcel.dataPosition();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d(LOG_TAG, message);
    }
}
