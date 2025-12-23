package egovframework.com.edoc.clsf.domain.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "문서분류")
@Getter
@Setter
public class DocClsfVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3067138537477155300L;

	@Schema(description = "문서분류번호", example = "")
	private String docClsfNo; // 문서분류번호

	@Schema(description = "문서분류 구분코드(L:대,M:중,S:소)", example = "")
	private String docClsfSeCd; // 문서분류 구분코드(L:대,M:중,S:소)

	@Schema(description = "문서분류명", example = "")
	private String docClsfNm; // 문서분류명

	@Schema(description = "상위문서분류번호", example = "")
	private String upDocClsfNo; // 상위문서분류번호

	@Schema(description = "개인정보 포함여부(Y:포함, N:미포함)", example = "")
	private String prvcInclYn; // 개인정보 포함여부(Y:포함, N:미포함)

	@Schema(description = "사용유무(Y:사용, N:미사용)", example = "")
	private String useEn; // 사용유무(Y:사용, N:미사용)

	@Schema(description = "등록일자", example = "")
	private Date regYmd; // 등록일자

	@Schema(description = "등록자", example = "")
	private String rgtrId; // 등록자

	@Schema(description = "수정일자", example = "")
	private Date mdfcnYmd; // 수정일자

	@Schema(description = "수정자", example = "")
	private String mdfrId; // 수정자

	@Schema(description = "개인정보파일보유현황", example = "")
	private PrvcFileHldPrstVO prvcFileHldPrst;

	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}