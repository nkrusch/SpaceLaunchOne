/*
 * Launch Library
 * The Launch Library API is a product by The Space Devs with an up-to-date database of Spaceflight events.   While this API is free to use it is subject to rate limiting for non-authenticated requests.  Please use https://lldev.thespacedevs.com for development testing - this endpoint has stale data but is not subject to any rate limits.  If you are interested in a higher rate limit please consider supporting the project on Patreon for access to an API Key.
 *
 * OpenAPI spec version: 2.2.0
 * Contact: support@thespacedevs.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * LocationDetail
 */
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
  private List<PadSerializerNoLocation> pads = new ArrayList<PadSerializerNoLocation>();

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public LocationDetail name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocationDetail countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

   /**
   * Get countryCode
   * @return countryCode
  **/
  @ApiModelProperty(value = "")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

   /**
   * Get mapImage
   * @return mapImage
  **/
  @ApiModelProperty(value = "")
  public String getMapImage() {
    return mapImage;
  }

   /**
   * Get totalLaunchCount
   * @return totalLaunchCount
  **/
  @ApiModelProperty(value = "")
  public String getTotalLaunchCount() {
    return totalLaunchCount;
  }

   /**
   * Get totalLandingCount
   * @return totalLandingCount
  **/
  @ApiModelProperty(value = "")
  public String getTotalLandingCount() {
    return totalLandingCount;
  }

  public LocationDetail pads(List<PadSerializerNoLocation> pads) {
    this.pads = pads;
    return this;
  }

  public LocationDetail addPadsItem(PadSerializerNoLocation padsItem) {
    this.pads.add(padsItem);
    return this;
  }

   /**
   * Get pads
   * @return pads
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
    return Objects.equals(this.id, locationDetail.id) &&
        Objects.equals(this.name, locationDetail.name) &&
        Objects.equals(this.countryCode, locationDetail.countryCode) &&
        Objects.equals(this.mapImage, locationDetail.mapImage) &&
        Objects.equals(this.totalLaunchCount, locationDetail.totalLaunchCount) &&
        Objects.equals(this.totalLandingCount, locationDetail.totalLandingCount) &&
        Objects.equals(this.pads, locationDetail.pads);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, countryCode, mapImage, totalLaunchCount, totalLandingCount, pads);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mapImage: ").append(toIndentedString(mapImage)).append("\n");
    sb.append("    totalLaunchCount: ").append(toIndentedString(totalLaunchCount)).append("\n");
    sb.append("    totalLandingCount: ").append(toIndentedString(totalLandingCount)).append("\n");
    sb.append("    pads: ").append(toIndentedString(pads)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
