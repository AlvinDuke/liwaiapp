package top.duyt.dao.impl;

import org.springframework.stereotype.Repository;

import top.duyt.dao.IDocumentDao;
import top.duyt.domain.Document;

@Repository("documentDao")
public class DocumentDao extends BaseDao<Document> implements IDocumentDao{

}
