/**
 * Launch Library
 * The Launch Library API is a product by The Space Devs with an up-to-date database of Spaceflight events.
 *
 * OpenAPI spec version: v2.0.0
 * Contact: support@thespacedevs.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import io.swagger.client.model.AgencySerializerMini;
import java.util.*;
import java.util.Date;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Program {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("agencies")
  private List<AgencySerializerMini> agencies = null;
  @SerializedName("image_url")
  private String imageUrl = null;
  @SerializedName("start_date")
  private Date startDate = null;
  @SerializedName("end_date")
  private Date endDate = null;
  @SerializedName("info_url")
  private String infoUrl = null;
  @SerializedName("wiki_url")
  private String wikiUrl = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<AgencySerializerMini> getAgencies() {
    return agencies;
  }
  public void setAgencies(List<AgencySerializerMini> agencies) {
    this.agencies = agencies;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getInfoUrl() {
    return infoUrl;
  }
  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getWikiUrl() {
    return wikiUrl;
  }
  public void setWikiUrl(String wikiUrl) {
    this.wikiUrl = wikiUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Program program = (Program) o;
    return (this.id == null ? program.id == null : this.id.equals(program.id)) &&
        (this.url == null ? program.url == null : this.url.equals(program.url)) &&
        (this.name == null ? program.name == null : this.name.equals(program.name)) &&
        (this.description == null ? program.description == null : this.description.equals(program.description)) &&
        (this.agencies == null ? program.agencies == null : this.agencies.equals(program.agencies)) &&
        (this.imageUrl == null ? program.imageUrl == null : this.imageUrl.equals(program.imageUrl)) &&
        (this.startDate == null ? program.startDate == null : this.startDate.equals(program.startDate)) &&
        (this.endDate == null ? program.endDate == null : this.endDate.equals(program.endDate)) &&
        (this.infoUrl == null ? program.infoUrl == null : this.infoUrl.equals(program.infoUrl)) &&
        (this.wikiUrl == null ? program.wikiUrl == null : this.wikiUrl.equals(program.wikiUrl));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.agencies == null ? 0: this.agencies.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.startDate == null ? 0: this.startDate.hashCode());
    result = 31 * result + (this.endDate == null ? 0: this.endDate.hashCode());
    result = 31 * result + (this.infoUrl == null ? 0: this.infoUrl.hashCode());
    result = 31 * result + (this.wikiUrl == null ? 0: this.wikiUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Program {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  agencies: ").append(agencies).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  startDate: ").append(startDate).append("\n");
    sb.append("  endDate: ").append(endDate).append("\n");
    sb.append("  infoUrl: ").append(infoUrl).append("\n");
    sb.append("  wikiUrl: ").append(wikiUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
