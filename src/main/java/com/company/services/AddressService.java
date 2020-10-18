package com.company.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AddressService {
    public static HashMap<String, String> getAddresses(){
        HashMap<String, String> addresses = new HashMap<>();

        addresses.put("jsp/img/ps1.jpg", "Nur-Sultan, Abay 132");
        addresses.put("jsp/img/ps2.jpg", "Almaty, Altynsarin 76");
        addresses.put("jsp/img/ps3.jpg", "Kostanay, Doshanova 143");

        return addresses;
    }

    public static Set<String> getCert(){
        Set<String> certs = new HashSet<String>();

        certs.add("jsp/img/ce.jpg");
        certs.add("jsp/img/ce1.png");
        certs.add("jsp/img/ce2.jpg");

        return certs;
    }
}
