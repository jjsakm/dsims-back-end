package egovframework.com.edoc.clsf.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import egovframework.com.edoc.clsf.domain.model.PrvcFileHldPrstVO;
import egovframework.com.edoc.clsf.dto.request.PrvcFileHldPrstInsertRequestDto;

@Mapper
public interface PrvcFileHldPrstMapper {
	
	PrvcFileHldPrstVO select(String docClsfNo);

	int insert(PrvcFileHldPrstInsertRequestDto prvcFieldHldPrst);
}
