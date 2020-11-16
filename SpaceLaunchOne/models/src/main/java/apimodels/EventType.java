package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class EventType {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty(required = true)
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventType eventType = (EventType) o;
    return (Objects.equals(this.id, eventType.id)) &&
        (Objects.equals(this.name, eventType.name));
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

    return "class EventType {\n" +
            "  id: " + id + "\n" +
            "  name: " + name + "\n" +
            "}\n";
  }
}
