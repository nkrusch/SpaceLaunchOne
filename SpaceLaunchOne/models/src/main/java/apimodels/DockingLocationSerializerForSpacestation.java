package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class DockingLocationSerializerForSpacestation {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("docked")
  private DockingEventDetailedSerializerForSpacestation docked = null;

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
  @ApiModelProperty()
  public DockingEventDetailedSerializerForSpacestation getDocked() {
    return docked;
  }
  public void setDocked(DockingEventDetailedSerializerForSpacestation docked) {
    this.docked = docked;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DockingLocationSerializerForSpacestation dockingLocationSerializerForSpacestation = (DockingLocationSerializerForSpacestation) o;
    return (Objects.equals(this.id, dockingLocationSerializerForSpacestation.id)) &&
        (Objects.equals(this.name, dockingLocationSerializerForSpacestation.name)) &&
        (Objects.equals(this.docked, dockingLocationSerializerForSpacestation.docked));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.docked == null ? 0: this.docked.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class DockingLocationSerializerForSpacestation {\n" +
            "  id: " + id + "\n" +
            "  name: " + name + "\n" +
            "  docked: " + docked + "\n" +
            "}\n";
  }
}
