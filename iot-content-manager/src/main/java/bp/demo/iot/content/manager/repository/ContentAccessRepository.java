package bp.demo.iot.content.manager.repository;

import bp.demo.iot.content.manager.repository.dao.ContentAccessDAO;
import bp.demo.iot.content.manager.repository.dao.ContentAccessKeyDAO;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ContentAccessRepository
  extends CassandraRepository<ContentAccessDAO, ContentAccessKeyDAO> {

}
