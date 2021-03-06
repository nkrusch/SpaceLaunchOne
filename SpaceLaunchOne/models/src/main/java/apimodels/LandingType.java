package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LandingType {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("abbrev")
  private String abbrev = null;
  @SerializedName("description")
  private String description = null;

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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LandingType landingType = (LandingType) o;
    return (Objects.equals(this.id, landingType.id)) &&
        (Objects.equals(this.name, landingType.name)) &&
        (Objects.equals(this.abbrev, landingType.abbrev)) &&
        (Objects.equals(this.description, landingType.description));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.abbrev == null ? 0: this.abbrev.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LandingType {\n" +
            "  id: " + id + "\n" +
            "  name: " + name + "\n" +
            "  abbrev: " + abbrev + "\n" +
            "  description: " + description + "\n" +
            "}\n";
  }
}
