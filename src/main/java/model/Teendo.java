package com.example.teendo.model;

public class Teendo {
    private Long id;
    private String cim;
    private String leiras;
    private boolean elvegzett;

    public Teendo() {}

    public Teendo(Long id, String cim, String leiras, boolean elvegzett) {
        this.id = id;
        this.cim = cim;
        this.leiras = leiras;
        this.elvegzett = elvegzett;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCim() { return cim; }
    public void setCim(String cim) { this.cim = cim; }

    public String getLeiras() { return leiras; }
    public void setLeiras(String leiras) { this.leiras = leiras; }

    public boolean isElvegzett() { return elvegzett; }
    public void setElvegzett(boolean elvegzett) { this.elvegzett = elvegzett; }
}