package bp.demo.iot.content.manager.service.helper;

import bp.demo.iot.content.manager.repository.dao.ContentAccessDAO;
import bp.demo.iot.content.manager.model.ContentAccess;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentServiceHelper {

  @Autowired
  private ModelMapper modelMapper;

  public ContentAccessDAO convertToDAO(ContentAccess contentAccess) {

    PropertyMap<ContentAccess, ContentAccessDAO> prMap =
            new PropertyMap<ContentAccess,ContentAccessDAO>() {
              protected void configure() {
                map().getKeyDAO().setCarrierName(source.getCarrierName());
                map().getKeyDAO().setUserId(source.getUserId());
                map().setContentTypes(source.getContentTypes());
                map().setAccessResult(source.getAccessResult());
                map().setTimeStamp(source.getTimeStamp());
              }
            };

    TypeMap<ContentAccess, ContentAccessDAO> typeMap
            = modelMapper.getTypeMap(ContentAccess.class, ContentAccessDAO.class);

    if (typeMap == null) {
      modelMapper.addMappings(prMap);
    }

    return modelMapper.map(contentAccess, ContentAccessDAO.class);

  }

  public ContentAccess convertToEntity(ContentAccessDAO dao) {

    PropertyMap<ContentAccessDAO, ContentAccess> caMap
            = new PropertyMap<ContentAccessDAO, ContentAccess>() {
      protected void configure() {
        map().setCarrierName(source.getKeyDAO().getCarrierName());
        map().setUserId(source.getKeyDAO().getUserId());
        map().setContentTypes(source.getContentTypes());
        map().setAccessResult(source.getAccessResult());
        map().setTimeStamp(source.getTimeStamp());
      }
    };

    TypeMap<ContentAccessDAO, ContentAccess> typeMap
            = modelMapper.getTypeMap(ContentAccessDAO.class, ContentAccess.class);

    if(typeMap ==null){
        modelMapper.addMappings(caMap);
    }

    return modelMapper.map(dao, ContentAccess.class);
  }

}
