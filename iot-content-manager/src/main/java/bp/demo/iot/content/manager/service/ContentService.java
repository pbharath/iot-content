package bp.demo.iot.content.manager.service;

import bp.demo.iot.content.manager.model.ContentAccess;
import bp.demo.iot.content.manager.repository.ContentAccessRepository;
import bp.demo.iot.content.manager.repository.dao.ContentAccessDAO;
import bp.demo.iot.content.manager.repository.dao.ContentAccessKeyDAO;
import bp.demo.iot.content.manager.service.helper.ContentServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentService {

  @Autowired
  private ContentAccessRepository contentAccessRepository;

  @Autowired
  private ContentServiceHelper contentServiceHelper;


  public boolean upsertContentAccess(ContentAccess contentAccess) {

    ContentAccessDAO dao = contentServiceHelper.convertToDAO(contentAccess);
    contentAccessRepository.insert(dao);

    return true;
  }

  public boolean isAccessGranted(ContentAccess contentAccess)
    throws Exception {

    ContentAccessKeyDAO keyDAO = new ContentAccessKeyDAO(
            contentAccess.getCarrierName(), contentAccess.getUserId());

    Optional<ContentAccessDAO> optionalDaoList =
            contentAccessRepository.findById(keyDAO);

    if(optionalDaoList.isPresent())
      return optionalDaoList.get().getAccessResult();
    else
      return false;
  }

}
