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

package ll2.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class LauncherConfig {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("launch_library_id")
  private Integer launchLibraryId = null;
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
   **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty(value = "")
  public Integer getLaunchLibraryId() {
    return launchLibraryId;
  }
  public void setLaunchLibraryId(Integer launchLibraryId) {
    this.launchLibraryId = launchLibraryId;
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
  public Agency getManufacturer() {
    return manufacturer;
  }
  public void setManufacturer(Agency manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<Program> getProgram() {
    return program;
  }
  public void setProgram(List<Program> program) {
    this.program = program;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getFamily() {
    return family;
  }
  public void setFamily(String family) {
    this.family = family;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getVariant() {
    return variant;
  }
  public void setVariant(String variant) {
    this.variant = variant;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getReusable() {
    return reusable;
  }
  public void setReusable(Boolean reusable) {
    this.reusable = reusable;
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
    LauncherConfig launcherConfig = (LauncherConfig) o;
    return (this.id == null ? launcherConfig.id == null : this.id.equals(launcherConfig.id)) &&
        (this.launchLibraryId == null ? launcherConfig.launchLibraryId == null : this.launchLibraryId.equals(launcherConfig.launchLibraryId)) &&
        (this.url == null ? launcherConfig.url == null : this.url.equals(launcherConfig.url)) &&
        (this.name == null ? launcherConfig.name == null : this.name.equals(launcherConfig.name)) &&
        (this.manufacturer == null ? launcherConfig.manufacturer == null : this.manufacturer.equals(launcherConfig.manufacturer)) &&
        (this.program == null ? launcherConfig.program == null : this.program.equals(launcherConfig.program)) &&
        (this.family == null ? launcherConfig.family == null : this.family.equals(launcherConfig.family)) &&
        (this.fullName == null ? launcherConfig.fullName == null : this.fullName.equals(launcherConfig.fullName)) &&
        (this.variant == null ? launcherConfig.variant == null : this.variant.equals(launcherConfig.variant)) &&
        (this.reusable == null ? launcherConfig.reusable == null : this.reusable.equals(launcherConfig.reusable)) &&
        (this.imageUrl == null ? launcherConfig.imageUrl == null : this.imageUrl.equals(launcherConfig.imageUrl)) &&
        (this.infoUrl == null ? launcherConfig.infoUrl == null : this.infoUrl.equals(launcherConfig.infoUrl)) &&
        (this.wikiUrl == null ? launcherConfig.wikiUrl == null : this.wikiUrl.equals(launcherConfig.wikiUrl));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.launchLibraryId == null ? 0: this.launchLibraryId.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.manufacturer == null ? 0: this.manufacturer.hashCode());
    result = 31 * result + (this.program == null ? 0: this.program.hashCode());
    result = 31 * result + (this.family == null ? 0: this.family.hashCode());
    result = 31 * result + (this.fullName == null ? 0: this.fullName.hashCode());
    result = 31 * result + (this.variant == null ? 0: this.variant.hashCode());
    result = 31 * result + (this.reusable == null ? 0: this.reusable.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.infoUrl == null ? 0: this.infoUrl.hashCode());
    result = 31 * result + (this.wikiUrl == null ? 0: this.wikiUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class LauncherConfig {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  launchLibraryId: ").append(launchLibraryId).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  manufacturer: ").append(manufacturer).append("\n");
    sb.append("  program: ").append(program).append("\n");
    sb.append("  family: ").append(family).append("\n");
    sb.append("  fullName: ").append(fullName).append("\n");
    sb.append("  variant: ").append(variant).append("\n");
    sb.append("  reusable: ").append(reusable).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  infoUrl: ").append(infoUrl).append("\n");
    sb.append("  wikiUrl: ").append(wikiUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}