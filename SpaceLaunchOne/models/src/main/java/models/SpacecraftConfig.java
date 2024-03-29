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

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * SpacecraftConfig
 */

public class SpacecraftConfig {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("type")
  private SpacecraftConfigType type = null;

  @SerializedName("agency")
  private AgencySerializerMini agency = null;

  @SerializedName("in_use")
  private Boolean inUse = null;

  @SerializedName("image_url")
  private String imageUrl = null;

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public SpacecraftConfig name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SpacecraftConfig type(SpacecraftConfigType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public SpacecraftConfigType getType() {
    return type;
  }

  public void setType(SpacecraftConfigType type) {
    this.type = type;
  }

  public SpacecraftConfig agency(AgencySerializerMini agency) {
    this.agency = agency;
    return this;
  }

   /**
   * Get agency
   * @return agency
  **/
  @ApiModelProperty(value = "")
  public AgencySerializerMini getAgency() {
    return agency;
  }

  public void setAgency(AgencySerializerMini agency) {
    this.agency = agency;
  }

  public SpacecraftConfig inUse(Boolean inUse) {
    this.inUse = inUse;
    return this;
  }

   /**
   * Get inUse
   * @return inUse
  **/
  @ApiModelProperty(value = "")
  public Boolean isInUse() {
    return inUse;
  }

  public void setInUse(Boolean inUse) {
    this.inUse = inUse;
  }

   /**
   * Get imageUrl
   * @return imageUrl
  **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftConfig spacecraftConfig = (SpacecraftConfig) o;
    return Objects.equals(this.id, spacecraftConfig.id) &&
        Objects.equals(this.url, spacecraftConfig.url) &&
        Objects.equals(this.name, spacecraftConfig.name) &&
        Objects.equals(this.type, spacecraftConfig.type) &&
        Objects.equals(this.agency, spacecraftConfig.agency) &&
        Objects.equals(this.inUse, spacecraftConfig.inUse) &&
        Objects.equals(this.imageUrl, spacecraftConfig.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, name, type, agency, inUse, imageUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpacecraftConfig {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    agency: ").append(toIndentedString(agency)).append("\n");
    sb.append("    inUse: ").append(toIndentedString(inUse)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
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

