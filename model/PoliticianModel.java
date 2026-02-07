package model;

public class PoliticianModel {
    String politicianId;
    String name;
    String party;

    public PoliticianModel(String politicianId, String name, String party) {
        this.politicianId = politicianId;
        this.name = name;
        this.party = party;
    }

    public String getPoliticianId() {
        return politicianId;
    }

    public String getName() {
        return name;
    }  
    public String getParty() {
        return party;
    }
    
}
