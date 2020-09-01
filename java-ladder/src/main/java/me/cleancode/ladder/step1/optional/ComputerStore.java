package me.cleancode.ladder.step1.optional;

import me.cleancode.ladder.step1.optional.Computer.Soundcard;
import me.cleancode.ladder.step1.optional.Computer.USB;

public class ComputerStore {
    public static final String UNKNOWN_VERSION = "UNKNOWN";

    public static String getVersion(Computer computer) {
        String version = UNKNOWN_VERSION;
        if (computer != null) {
            Soundcard soundcard = computer.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUsb();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }
        return version;
    }

    public static String getVersionOptional(Computer computer) {
        return null;
    }
}