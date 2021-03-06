package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LaunchSerializerMini {
  
  @SerializedName("id")
  private UUID id = null;
  @SerializedName("name")
  private String name = null;

  /**
   **/
  @ApiModelProperty()
  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LaunchSerializerMini launchSerializerMini = (LaunchSerializerMini) o;
    return (Objects.equals(this.id, launchSerializerMini.id)) &&
        (Objects.equals(this.name, launchSerializerMini.name));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LaunchSerializerMini {\n" +
            "  id: " + id + "\n" +
            "  name: " + name + "\n" +
            "}\n";
  }
}
