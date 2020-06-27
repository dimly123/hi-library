package com.jzx.hi.hilibrary.log;

import android.os.Environment;

import androidx.annotation.NonNull;

public class HiFilePrinter implements HiLogPrinter {
    @Override
    public void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString) {

    }

    public void getFileIO(){
        Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED) ;

    }
}
