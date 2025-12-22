package egovframework.com.edoc.clsf.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import egovframework.com.edoc.clsf.domain.model.PrvcFileHldPrstVO;
import egovframework.com.edoc.clsf.dto.request.PrvcFileHldPrstUpsertRequestDto;

@Mapper
public interface PrvcFileHldPrstMapper {
	
	PrvcFileHldPrstVO select(String docClsfNo);

	int insert(PrvcFileHldPrstUpsertRequestDto dto);

	int update(PrvcFileHldPrstUpsertRequestDto dto);

	int delete(String docClsfNo, String prvcFileHldPrstNo);
}
