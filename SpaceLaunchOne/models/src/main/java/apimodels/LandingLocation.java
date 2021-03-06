package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LandingLocation {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("abbrev")
  private String abbrev = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("location")
  private Location location = null;
  @SerializedName("successful_landings")
  private String successfulLandings = null;

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
  public String getAbbrev() {
    return abbrev;
  }
  public void setAbbrev(String abbrev) {
    this.abbrev = abbrev;
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
  @ApiModelProperty(required = true)
  public Location getLocation() {
    return location;
  }
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   **/
  @ApiModelProperty()
  public String getSuccessfulLandings() {
    return successfulLandings;
  }
  public void setSuccessfulLandings(String successfulLandings) {
    this.successfulLandings = successfulLandings;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LandingLocation landingLocation = (LandingLocation) o;
    return (Objects.equals(this.id, landingLocation.id)) &&
        (Objects.equals(this.name, landingLocation.name)) &&
        (Objects.equals(this.abbrev, landingLocation.abbrev)) &&
        (Objects.equals(this.description, landingLocation.description)) &&
        (Objects.equals(this.location, landingLocation.location)) &&
        (Objects.equals(this.successfulLandings, landingLocation.successfulLandings));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.abbrev == null ? 0: this.abbrev.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.location == null ? 0: this.location.hashCode());
    result = 31 * result + (this.successfulLandings == null ? 0: this.successfulLandings.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LandingLocation {\n" +
            "  id: " + id + "\n" +
            "  name: " + name + "\n" +
            "  abbrev: " + abbrev + "\n" +
            "  description: " + description + "\n" +
            "  location: " + location + "\n" +
            "  successfulLandings: " + successfulLandings + "\n" +
            "}\n";
  }
}
