package com.example.inter_sporty_guru;

public class collage_data {

    public String coll_name;
    public String coll_country;
    public String coll_state;
    public String coll_webpage;

    public String getColl_country() {
        return coll_country;
    }

    public String getColl_state() {
        return coll_state;
    }

    public String getColl_webpage() {
        return coll_webpage;
    }

    public void setColl_country(String coll_country) {
        this.coll_country = coll_country;
    }

    public void setColl_state(String coll_state) {
        this.coll_state = coll_state;
    }

    public void setColl_webpage(String coll_webpage) {
        this.coll_webpage = coll_webpage;
    }

    public collage_data() {

    }

    public collage_data(String coll_name) {
        this.coll_name = coll_name;
    }

    public String getColl_name() {
        return coll_name;
    }

    public void setColl_name(String coll_name) {
        this.coll_name = coll_name;
    }

}
