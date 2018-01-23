package com.example.sahar.mmiscreenprofiledetails;

/**
 * Created by sahar on 23/1/18.
 */

public class DataModel {
  private String label;
  private String details;

  public DataModel(String label,String details){
      this.setLabel(label);
      this.setDetails(details);
  }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label=label;
    }

    public String getDetails(){
        return details;
    }

    public void setDetails(String details){
        this.details=details;
    }
}
