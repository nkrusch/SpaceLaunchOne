package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LauncherConfigList {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("launch_library_id")
  private Integer launchLibraryId = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("family")
  private String family = null;
  @SerializedName("full_name")
  private String fullName = null;
  @SerializedName("variant")
  private String variant = null;

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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LauncherConfigList launcherConfigList = (LauncherConfigList) o;
    return (Objects.equals(this.id, launcherConfigList.id)) &&
        (Objects.equals(this.launchLibraryId, launcherConfigList.launchLibraryId)) &&
        (Objects.equals(this.url, launcherConfigList.url)) &&
        (Objects.equals(this.name, launcherConfigList.name)) &&
        (Objects.equals(this.family, launcherConfigList.family)) &&
        (Objects.equals(this.fullName, launcherConfigList.fullName)) &&
        (Objects.equals(this.variant, launcherConfigList.variant));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.launchLibraryId == null ? 0: this.launchLibraryId.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.family == null ? 0: this.family.hashCode());
    result = 31 * result + (this.fullName == null ? 0: this.fullName.hashCode());
    result = 31 * result + (this.variant == null ? 0: this.variant.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LauncherConfigList {\n" +
            "  id: " + id + "\n" +
            "  launchLibraryId: " + launchLibraryId + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  family: " + family + "\n" +
            "  fullName: " + fullName + "\n" +
            "  variant: " + variant + "\n" +
            "}\n";
  }
}
