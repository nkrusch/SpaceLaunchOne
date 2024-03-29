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

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * LauncherConfig
 */

public class LauncherConfig {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("manufacturer")
  private Agency manufacturer = null;

  @SerializedName("program")
  private List<Program> program = null;

  @SerializedName("family")
  private String family = null;

  @SerializedName("full_name")
  private String fullName = null;

  @SerializedName("variant")
  private String variant = null;

  @SerializedName("reusable")
  private Boolean reusable = null;

  @SerializedName("image_url")
  private String imageUrl = null;

  @SerializedName("info_url")
  private String infoUrl = null;

  @SerializedName("wiki_url")
  private String wikiUrl = null;

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

  public LauncherConfig name(String name) {
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

  public LauncherConfig manufacturer(Agency manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

   /**
   * Get manufacturer
   * @return manufacturer
  **/
  @ApiModelProperty(value = "")
  public Agency getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Agency manufacturer) {
    this.manufacturer = manufacturer;
  }

   /**
   * Get program
   * @return program
  **/
  @ApiModelProperty(value = "")
  public List<Program> getProgram() {
    return program;
  }

  public LauncherConfig family(String family) {
    this.family = family;
    return this;
  }

   /**
   * Get family
   * @return family
  **/
  @ApiModelProperty(value = "")
  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public LauncherConfig fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

   /**
   * Get fullName
   * @return fullName
  **/
  @ApiModelProperty(value = "")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public LauncherConfig variant(String variant) {
    this.variant = variant;
    return this;
  }

   /**
   * Get variant
   * @return variant
  **/
  @ApiModelProperty(value = "")
  public String getVariant() {
    return variant;
  }

  public void setVariant(String variant) {
    this.variant = variant;
  }

  public LauncherConfig reusable(Boolean reusable) {
    this.reusable = reusable;
    return this;
  }

   /**
   * Get reusable
   * @return reusable
  **/
  @ApiModelProperty(value = "")
  public Boolean isReusable() {
    return reusable;
  }

  public void setReusable(Boolean reusable) {
    this.reusable = reusable;
  }

   /**
   * Get imageUrl
   * @return imageUrl
  **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }

  public LauncherConfig infoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
    return this;
  }

   /**
   * Get infoUrl
   * @return infoUrl
  **/
  @ApiModelProperty(value = "")
  public String getInfoUrl() {
    return infoUrl;
  }

  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }

  public LauncherConfig wikiUrl(String wikiUrl) {
    this.wikiUrl = wikiUrl;
    return this;
  }

   /**
   * Get wikiUrl
   * @return wikiUrl
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
    LauncherConfig launcherConfig = (LauncherConfig) o;
    return Objects.equals(this.id, launcherConfig.id) &&
        Objects.equals(this.url, launcherConfig.url) &&
        Objects.equals(this.name, launcherConfig.name) &&
        Objects.equals(this.manufacturer, launcherConfig.manufacturer) &&
        Objects.equals(this.program, launcherConfig.program) &&
        Objects.equals(this.family, launcherConfig.family) &&
        Objects.equals(this.fullName, launcherConfig.fullName) &&
        Objects.equals(this.variant, launcherConfig.variant) &&
        Objects.equals(this.reusable, launcherConfig.reusable) &&
        Objects.equals(this.imageUrl, launcherConfig.imageUrl) &&
        Objects.equals(this.infoUrl, launcherConfig.infoUrl) &&
        Objects.equals(this.wikiUrl, launcherConfig.wikiUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, name, manufacturer, program, family, fullName, variant, reusable, imageUrl, infoUrl, wikiUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LauncherConfig {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    program: ").append(toIndentedString(program)).append("\n");
    sb.append("    family: ").append(toIndentedString(family)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
    sb.append("    reusable: ").append(toIndentedString(reusable)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    infoUrl: ").append(toIndentedString(infoUrl)).append("\n");
    sb.append("    wikiUrl: ").append(toIndentedString(wikiUrl)).append("\n");
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

