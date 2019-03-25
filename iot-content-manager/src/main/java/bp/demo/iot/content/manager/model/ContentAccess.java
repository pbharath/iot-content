package bp.demo.iot.content.manager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class ContentAccess
  implements Serializable {

  private String carrierName;

  private UUID userId;

  private Set<String> contentTypes;

  private boolean accessResult;

  private Date timeStamp;

  public ContentAccess() {
  }

  public ContentAccess( String carrierName, UUID userId,
                       String deviceId, Set<String> contentType,
                       boolean accessResult, Date timeStamp) {
    this.carrierName = carrierName;
    this.userId = userId;
    this.contentTypes = contentTypes;
    this.accessResult = accessResult;
    this.timeStamp = timeStamp;
  }

  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public Set<String> getContentTypes() {
    return contentTypes;
  }

  public void setContentTypes(Set<String> contentTypes) {
    this.contentTypes = contentTypes;
  }

  public boolean getAccessResult() {
    return accessResult;
  }

  public void setAccessResult(boolean accessResult) {
    this.accessResult = accessResult;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContentAccess that = (ContentAccess) o;
    return getAccessResult() == that.getAccessResult() &&
            getCarrierName().equals(that.getCarrierName()) &&
            getUserId().equals(that.getUserId()) &&
            getContentTypes().equals(that.getContentTypes()) &&
            getTimeStamp().equals(that.getTimeStamp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCarrierName(), getUserId(),
            getContentTypes(), getAccessResult(), getTimeStamp());
  }

  @Override
  public String toString() {
    return "ContentAccess{" +
              "carrierName='" + carrierName + '\'' + ", " +
              "userId='" + userId + '\'' +
              ", contentTypes=" + contentTypes +
              ", accessResult=" + accessResult +
              ", timeStamp=" + timeStamp + '}';
  }
}
