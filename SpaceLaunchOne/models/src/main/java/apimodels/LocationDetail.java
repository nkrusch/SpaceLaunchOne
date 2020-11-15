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

package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class LocationDetail {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("country_code")
  private String countryCode = null;
  @SerializedName("map_image")
  private String mapImage = null;
  @SerializedName("total_launch_count")
  private String totalLaunchCount = null;
  @SerializedName("total_landing_count")
  private String totalLandingCount = null;
  @SerializedName("pads")
  private List<PadSerializerNoLocation> pads = null;

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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getMapImage() {
    return mapImage;
  }
  public void setMapImage(String mapImage) {
    this.mapImage = mapImage;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getTotalLaunchCount() {
    return totalLaunchCount;
  }
  public void setTotalLaunchCount(String totalLaunchCount) {
    this.totalLaunchCount = totalLaunchCount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getTotalLandingCount() {
    return totalLandingCount;
  }
  public void setTotalLandingCount(String totalLandingCount) {
    this.totalLandingCount = totalLandingCount;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<PadSerializerNoLocation> getPads() {
    return pads;
  }
  public void setPads(List<PadSerializerNoLocation> pads) {
    this.pads = pads;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationDetail locationDetail = (LocationDetail) o;
    return (this.id == null ? locationDetail.id == null : this.id.equals(locationDetail.id)) &&
        (this.name == null ? locationDetail.name == null : this.name.equals(locationDetail.name)) &&
        (this.countryCode == null ? locationDetail.countryCode == null : this.countryCode.equals(locationDetail.countryCode)) &&
        (this.mapImage == null ? locationDetail.mapImage == null : this.mapImage.equals(locationDetail.mapImage)) &&
        (this.totalLaunchCount == null ? locationDetail.totalLaunchCount == null : this.totalLaunchCount.equals(locationDetail.totalLaunchCount)) &&
        (this.totalLandingCount == null ? locationDetail.totalLandingCount == null : this.totalLandingCount.equals(locationDetail.totalLandingCount)) &&
        (this.pads == null ? locationDetail.pads == null : this.pads.equals(locationDetail.pads));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.countryCode == null ? 0: this.countryCode.hashCode());
    result = 31 * result + (this.mapImage == null ? 0: this.mapImage.hashCode());
    result = 31 * result + (this.totalLaunchCount == null ? 0: this.totalLaunchCount.hashCode());
    result = 31 * result + (this.totalLandingCount == null ? 0: this.totalLandingCount.hashCode());
    result = 31 * result + (this.pads == null ? 0: this.pads.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationDetail {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  countryCode: ").append(countryCode).append("\n");
    sb.append("  mapImage: ").append(mapImage).append("\n");
    sb.append("  totalLaunchCount: ").append(totalLaunchCount).append("\n");
    sb.append("  totalLandingCount: ").append(totalLandingCount).append("\n");
    sb.append("  pads: ").append(pads).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}