package bp.demo.iot.content.manager.repository.dao;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@PrimaryKeyClass
public class ContentAccessKeyDAO
  implements Serializable {

  @PrimaryKeyColumn(name = "carrier_name", type = PrimaryKeyType.PARTITIONED,
          ordinal = 1)
  private String carrierName;

  @PrimaryKeyColumn(value = "user_id", type = PrimaryKeyType.CLUSTERED)
  private UUID userId;

  public ContentAccessKeyDAO() {
  }

  public ContentAccessKeyDAO(String carrierName, UUID userId) {
    this.carrierName = carrierName;
    this.userId = userId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContentAccessKeyDAO that = (ContentAccessKeyDAO) o;
    return getCarrierName().equals(that.getCarrierName()) &&
            getUserId().equals(that.getUserId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCarrierName(), getUserId());
  }

  @Override
  public String toString() {
    return "ContentAccessKeyDAO{" + "carrierName='" + carrierName + '\'' + "," +
            " userId='" + userId + '\'' + '}';
  }
}
