package com.ninza.crm.model;

public class Lead {
	private String name;
    private String company;
    private String campaign;
    private String leadSource;
    private String industry;
    private String leadStatus;
    private String phone;

    // Constructor
    public Lead(String name, String company, String campaign,
                String leadSource, String industry, String leadStatus, String phone) {
        this.name = name;
        this.company = company;
        this.campaign = campaign;
        this.leadSource = leadSource;
        this.industry = industry;
        this.leadStatus = leadStatus;
        this.phone = phone;
    }
    public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public String getCampaign() {
		return campaign;
	}

	public String getLeadSource() {
		return leadSource;
	}

	public String getIndustry() {
		return industry;
	}

	public String getLeadStatus() {
		return leadStatus;
	}

	public String getPhone() {
		return phone;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}




}
