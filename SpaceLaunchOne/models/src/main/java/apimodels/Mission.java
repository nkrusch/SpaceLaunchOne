package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Mission {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("launch_library_id")
  private Integer launchLibraryId = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("launch_designator")
  private String launchDesignator = null;
  @SerializedName("type")
  private String type = null;
  @SerializedName("orbit")
  private Orbit orbit = null;

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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty()
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLaunchDesignator() {
    return launchDesignator;
  }
  public void setLaunchDesignator(String launchDesignator) {
    this.launchDesignator = launchDesignator;
  }

  /**
   **/
  @ApiModelProperty()
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public Orbit getOrbit() {
    return orbit;
  }
  public void setOrbit(Orbit orbit) {
    this.orbit = orbit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mission mission = (Mission) o;
    return (Objects.equals(this.id, mission.id)) &&
        (Objects.equals(this.launchLibraryId, mission.launchLibraryId)) &&
        (Objects.equals(this.name, mission.name)) &&
        (Objects.equals(this.description, mission.description)) &&
        (Objects.equals(this.launchDesignator, mission.launchDesignator)) &&
        (Objects.equals(this.type, mission.type)) &&
        (Objects.equals(this.orbit, mission.orbit));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.launchLibraryId == null ? 0: this.launchLibraryId.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.launchDesignator == null ? 0: this.launchDesignator.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.orbit == null ? 0: this.orbit.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class Mission {\n" +
            "  id: " + id + "\n" +
            "  launchLibraryId: " + launchLibraryId + "\n" +
            "  name: " + name + "\n" +
            "  description: " + description + "\n" +
            "  launchDesignator: " + launchDesignator + "\n" +
            "  type: " + type + "\n" +
            "  orbit: " + orbit + "\n" +
            "}\n";
  }
}
