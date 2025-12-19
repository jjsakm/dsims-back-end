package egovframework.com.edoc.clsf.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import egovframework.com.edoc.clsf.domain.model.DocumentClassificationSearchVO;
import egovframework.com.edoc.clsf.domain.model.DocumentClassificationVO;

@Mapper
public interface DocumentClassificationMapper {
	
	DocumentClassificationVO select(String no);
	
	List<DocumentClassificationVO> selectListByDocClsfSeCd(String docClsfSeCd);
	
	List<DocumentClassificationVO> selectListByUpDocClsfNo(String parentNo);

	List<DocumentClassificationVO> selectList(DocumentClassificationSearchVO searchVO);

	int selectListTotCnt(DocumentClassificationSearchVO searchVO);
}
