package model;

public class CampaignsModel {
    private String campaignId;
    private int electionYear;
    private String district;
    
    public CampaignsModel(String campaignId, int electionYear, String district) {
        this.campaignId = campaignId;
        this.electionYear = electionYear;
        this.district = district;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public int getElectionYear() {
        return electionYear;
    }

    public String getDistrict() {
        return district;
    }

    
}
