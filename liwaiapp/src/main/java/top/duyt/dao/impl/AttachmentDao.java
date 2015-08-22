package top.duyt.dao.impl;

import org.springframework.stereotype.Repository;

import top.duyt.dao.IAttachmentDao;
import top.duyt.domain.Attachment;

@Repository("attachmentDao")
public class AttachmentDao extends BaseDao<Attachment> implements IAttachmentDao{

}
