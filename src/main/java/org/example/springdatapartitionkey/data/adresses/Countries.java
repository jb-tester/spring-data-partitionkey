package org.example.springdatapartitionkey.data.adresses;


public enum Countries {
    GROUP1("Russia"),
    GROUP2("UK"),
    GROUP3("Czech Republic"),

    ;

    private final String key;

    Countries(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
