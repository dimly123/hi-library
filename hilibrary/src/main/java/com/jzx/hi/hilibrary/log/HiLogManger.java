package com.jzx.hi.hilibrary.log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HiLogManger {

    private HiLogConfig hiLogConfig;
    private static HiLogManger instance;

    private List<HiLogPrinter> printers = new ArrayList<>();

    private HiLogManger(HiLogConfig hiLogConfig, HiLogPrinter[] printers) {
        this.hiLogConfig = hiLogConfig;
        this.printers.addAll(Arrays.asList(printers));
    }
    public static HiLogManger getInstance() {
        return instance;
    }
    public static void init(@NonNull HiLogConfig config, HiLogPrinter... printers) {
        instance = new HiLogManger(config, printers);
    }
    public HiLogConfig getConfig() {
        return hiLogConfig;
    }
    public void addPrinter(HiLogPrinter printer) {
        printers.add(printer);
    }
    public void removePrinter(HiLogPrinter printer) {
        if (printers != null) {
            printers.remove(printer);
        }
    }
    public List<HiLogPrinter> getPrinters(){
        return printers;
    }
}
