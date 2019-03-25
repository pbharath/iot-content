package bp.demo.iot.content.manager.repository.dao;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Table("Content_Access")
public class ContentAccessDAO
  implements Serializable {

  @PrimaryKey
  private ContentAccessKeyDAO keyDAO;

  @Column(value = "content_types")
  private Set<String> contentTypes;

  @Column(value = "access_result")
  private boolean accessResult;

  @Column(value = "timestamp")
  private Date timeStamp;

  public ContentAccessDAO() {
  }

  public ContentAccessDAO(ContentAccessKeyDAO keyDAO, boolean accessResult,
                          Date timeStamp) {
    this.keyDAO = keyDAO;
    this.accessResult = accessResult;
    this.timeStamp = timeStamp;
  }

  public ContentAccessKeyDAO getKeyDAO() {
    return keyDAO;
  }

  public void setKeyDAO(ContentAccessKeyDAO keyDAO) {
    this.keyDAO = keyDAO;
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
    ContentAccessDAO that = (ContentAccessDAO) o;
    return getAccessResult() == that.getAccessResult() &&
            getKeyDAO().equals(that.getKeyDAO()) &&
            Objects.equals(getTimeStamp(), that.getTimeStamp());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getKeyDAO(), getAccessResult(), getTimeStamp());
  }

  @Override
  public String toString() {
    return "ContentAccessDAO{" +
            "keyDAO=" + keyDAO +
            ", accessResult=" + accessResult +
            ", timeStamp=" + timeStamp + '}';
  }
}
