package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class InlineResponse20014 {
  
  @SerializedName("count")
  private Integer count = null;
  @SerializedName("next")
  private String next = null;
  @SerializedName("previous")
  private String previous = null;
  @SerializedName("results")
  private List<SpaceStation> results = null;

  /**
   **/
  @ApiModelProperty(required = true)
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   **/
  @ApiModelProperty()
  public String getNext() {
    return next;
  }
  public void setNext(String next) {
    this.next = next;
  }

  /**
   **/
  @ApiModelProperty()
  public String getPrevious() {
    return previous;
  }
  public void setPrevious(String previous) {
    this.previous = previous;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public List<SpaceStation> getResults() {
    return results;
  }
  public void setResults(List<SpaceStation> results) {
    this.results = results;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20014 inlineResponse20014 = (InlineResponse20014) o;
    return (Objects.equals(this.count, inlineResponse20014.count)) &&
        (Objects.equals(this.next, inlineResponse20014.next)) &&
        (Objects.equals(this.previous, inlineResponse20014.previous)) &&
        (Objects.equals(this.results, inlineResponse20014.results));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.count == null ? 0: this.count.hashCode());
    result = 31 * result + (this.next == null ? 0: this.next.hashCode());
    result = 31 * result + (this.previous == null ? 0: this.previous.hashCode());
    result = 31 * result + (this.results == null ? 0: this.results.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class InlineResponse20014 {\n" +
            "  count: " + count + "\n" +
            "  next: " + next + "\n" +
            "  previous: " + previous + "\n" +
            "  results: " + results + "\n" +
            "}\n";
  }
}
