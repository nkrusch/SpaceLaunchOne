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

package io.swagger.client.model;

import io.swagger.client.model.DockingEventDetailedSerializerForSpacestation;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class DockingLocationSerializerForSpacestation {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("docked")
  private DockingEventDetailedSerializerForSpacestation docked = null;

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
    return (this.id == null ? dockingLocationSerializerForSpacestation.id == null : this.id.equals(dockingLocationSerializerForSpacestation.id)) &&
        (this.name == null ? dockingLocationSerializerForSpacestation.name == null : this.name.equals(dockingLocationSerializerForSpacestation.name)) &&
        (this.docked == null ? dockingLocationSerializerForSpacestation.docked == null : this.docked.equals(dockingLocationSerializerForSpacestation.docked));
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
    StringBuilder sb = new StringBuilder();
    sb.append("class DockingLocationSerializerForSpacestation {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  docked: ").append(docked).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
