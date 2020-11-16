package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Orbit {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("abbrev")
  private String abbrev = null;

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
  @ApiModelProperty(required = true)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getAbbrev() {
    return abbrev;
  }
  public void setAbbrev(String abbrev) {
    this.abbrev = abbrev;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Orbit orbit = (Orbit) o;
    return (Objects.equals(this.id, orbit.id)) &&
        (Objects.equals(this.name, orbit.name)) &&
        (Objects.equals(this.abbrev, orbit.abbrev));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.abbrev == null ? 0: this.abbrev.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class Orbit {\n" +
            "  id: " + id + "\n" +
            "  name: " + name + "\n" +
            "  abbrev: " + abbrev + "\n" +
            "}\n";
  }
}
