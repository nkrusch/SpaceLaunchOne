package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
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
  @ApiModelProperty()
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
  @ApiModelProperty()
  public Integer getLaunchLibraryId() {
    return launchLibraryId;
  }
  public void setLaunchLibraryId(Integer launchLibraryId) {
    this.launchLibraryId = launchLibraryId;
  }

  /**
   **/
  @ApiModelProperty()
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty()
  public Agency getManufacturer() {
    return manufacturer;
  }
  public void setManufacturer(Agency manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   **/
  @ApiModelProperty()
  public List<Program> getProgram() {
    return program;
  }
  public void setProgram(List<Program> program) {
    this.program = program;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFamily() {
    return family;
  }
  public void setFamily(String family) {
    this.family = family;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   **/
  @ApiModelProperty()
  public String getVariant() {
    return variant;
  }
  public void setVariant(String variant) {
    this.variant = variant;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getReusable() {
    return reusable;
  }
  public void setReusable(Boolean reusable) {
    this.reusable = reusable;
  }

  /**
   **/
  @ApiModelProperty()
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getInfoUrl() {
    return infoUrl;
  }
  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }

  /**
   **/
  @ApiModelProperty()
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
    return (Objects.equals(this.id, launcherConfig.id)) &&
        (Objects.equals(this.launchLibraryId, launcherConfig.launchLibraryId)) &&
        (Objects.equals(this.url, launcherConfig.url)) &&
        (Objects.equals(this.name, launcherConfig.name)) &&
        (Objects.equals(this.manufacturer, launcherConfig.manufacturer)) &&
        (Objects.equals(this.program, launcherConfig.program)) &&
        (Objects.equals(this.family, launcherConfig.family)) &&
        (Objects.equals(this.fullName, launcherConfig.fullName)) &&
        (Objects.equals(this.variant, launcherConfig.variant)) &&
        (Objects.equals(this.reusable, launcherConfig.reusable)) &&
        (Objects.equals(this.imageUrl, launcherConfig.imageUrl)) &&
        (Objects.equals(this.infoUrl, launcherConfig.infoUrl)) &&
        (Objects.equals(this.wikiUrl, launcherConfig.wikiUrl));
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

    return "class LauncherConfig {\n" +
            "  id: " + id + "\n" +
            "  launchLibraryId: " + launchLibraryId + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  manufacturer: " + manufacturer + "\n" +
            "  program: " + program + "\n" +
            "  family: " + family + "\n" +
            "  fullName: " + fullName + "\n" +
            "  variant: " + variant + "\n" +
            "  reusable: " + reusable + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "  infoUrl: " + infoUrl + "\n" +
            "  wikiUrl: " + wikiUrl + "\n" +
            "}\n";
  }
}
