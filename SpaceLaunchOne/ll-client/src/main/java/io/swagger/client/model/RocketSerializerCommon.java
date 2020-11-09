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

import io.swagger.client.model.LauncherConfigList;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class RocketSerializerCommon {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("configuration")
  private LauncherConfigList configuration = null;

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
  @ApiModelProperty(value = "")
  public LauncherConfigList getConfiguration() {
    return configuration;
  }
  public void setConfiguration(LauncherConfigList configuration) {
    this.configuration = configuration;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RocketSerializerCommon rocketSerializerCommon = (RocketSerializerCommon) o;
    return (this.id == null ? rocketSerializerCommon.id == null : this.id.equals(rocketSerializerCommon.id)) &&
        (this.configuration == null ? rocketSerializerCommon.configuration == null : this.configuration.equals(rocketSerializerCommon.configuration));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.configuration == null ? 0: this.configuration.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RocketSerializerCommon {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  configuration: ").append(configuration).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
