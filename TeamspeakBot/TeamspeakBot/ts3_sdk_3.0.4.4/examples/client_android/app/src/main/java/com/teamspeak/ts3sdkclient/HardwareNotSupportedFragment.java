package com.teamspeak.ts3sdkclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * TeamSpeak 3 sdk client sample
 *
 * Copyright (c) 2007-2017 TeamSpeak-Systems
 *
 * @author Alexej
 * Creation date: 08.02.17
 *
 * Fragment to display a Hardware incompatibility message with a button to exit the Application
 */
public class HardwareNotSupportedFragment extends Fragment {
    private final static String ARG_AUDIO_HARDWARE_UNSUPPORTED = "audioHardwareUnsupported";
    private final static String ARG_CPU_HARDWARE_UNSUPPORTED = "cpuHardwareUnsupported";

    private boolean cpuHardwareSupported;
    private boolean audioHardwareSupported;

    public HardwareNotSupportedFragment() {
    }

    public static HardwareNotSupportedFragment newInstance(boolean cpuHardwareSupported, boolean audioHardwareSupported) {
        Bundle args = new Bundle();
        HardwareNotSupportedFragment fragment = new HardwareNotSupportedFragment();
        args.putBoolean(ARG_CPU_HARDWARE_UNSUPPORTED, cpuHardwareSupported);
        args.putBoolean(ARG_AUDIO_HARDWARE_UNSUPPORTED, audioHardwareSupported);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cpuHardwareSupported = getArguments().getBoolean(ARG_CPU_HARDWARE_UNSUPPORTED);
            audioHardwareSupported = getArguments().getBoolean(ARG_AUDIO_HARDWARE_UNSUPPORTED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hardware_not_supported, container, false);

        LinearLayout cpuInfoLayout = (LinearLayout) view.findViewById(R.id.cpu_support_layout);
        LinearLayout audioInfoLayout = (LinearLayout) view.findViewById(R.id.audio_support_layout);

        cpuInfoLayout.setVisibility(cpuHardwareSupported ? View.GONE : View.VISIBLE);
        audioInfoLayout.setVisibility(audioHardwareSupported ? View.GONE : View.VISIBLE);

        return view;
    }

}
